package com.example.uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword;
    private Button btnRegister;
    private TextView tvLogin;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userRepository = UserRepository.getInstance();

        // Inisialisasi komponen UI
        etUsername = findViewById(R.id.et_username);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnRegister = findViewById(R.id.btn_register);
        tvLogin = findViewById(R.id.tv_login);

        // Set listener untuk tombol register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        // Set listener untuk text login
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke halaman login
                finish(); // Cukup tutup activity register untuk kembali ke login
            }
        });
    }

private void registerUser() {
    // Ambil nilai dari input
    String username = etUsername.getText().toString().trim();
    String email = etEmail.getText().toString().trim();
    String password = etPassword.getText().toString().trim();

    // Validasi input
    if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
        Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show();
        return;
    }

    // Validasi email (sederhana)
    if (!email.contains("@")) {
        Toast.makeText(this, "Format email tidak valid", Toast.LENGTH_SHORT).show();
        return;
    }

    // Validasi password (minimal 6 karakter)
    if (password.length() < 6) {
        Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show();
        return;
    }

    // Coba registrasi
    boolean registerSuccess = userRepository.registerUser(username, email, password);

    if (registerSuccess) {
        // Registrasi berhasil
        Toast.makeText(this, "Registrasi berhasil! Silakan login", Toast.LENGTH_SHORT).show();
        finish(); // Kembali ke halaman login
    } else {
        // Registrasi gagal
        Toast.makeText(this, "Username atau email sudah digunakan", Toast.LENGTH_SHORT).show();
    }
}
}