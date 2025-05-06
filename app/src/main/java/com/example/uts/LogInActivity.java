package com.example.uts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        userRepository = UserRepository.getInstance();


        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        // Ambil nilai dari input
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validasi input
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username dan password harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }


        boolean loginSuccess = userRepository.loginUser(username, password);

        if (loginSuccess) {

            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LogInActivity.this, Home.class);
            startActivity(intent);
            finish();
        } else {

            Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show();
        }
    }
}
