package com.example.uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DestinasiAdapter destinasiAdapter;
    private List<Destinasi> destinasiList;
    private TextView tvLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inisialisasi komponen UI
        recyclerView = findViewById(R.id.listview);
        tvLogout = findViewById(R.id.tv_logout);

        // Membuat data destinasi wisata
        buatDataDestinasi();

        // Mengatur layout manager untuk RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Membuat dan mengatur adapter
        destinasiAdapter = new DestinasiAdapter(this, destinasiList);
        recyclerView.setAdapter(destinasiAdapter);

        // Menangani klik pada item RecyclerView
        destinasiAdapter.setOnItemClickListener(new DestinasiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Destinasi destinasiTerpilih = destinasiList.get(position);
                // Di sini Anda bisa mengarahkan ke detail destinasi atau halaman pemesanan
                Toast.makeText(Home.this, "Anda memilih: " + destinasiTerpilih.getJudul(), Toast.LENGTH_SHORT).show();

                            }
        });

        // Menangani klik pada tombol logout
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementasi logout di sini
                Toast.makeText(Home.this, "Logout berhasil", Toast.LENGTH_SHORT).show();
                // Kembali ke halaman login
                 Intent intent = new Intent(Home.this, LogInActivity.class);
                 startActivity(intent);
                 finish();
            }
        });
    }

    // Membuat data contoh untuk destinasi wisata
    private void buatDataDestinasi() {
        destinasiList = new ArrayList<>();

        // Tambahkan contoh destinasi (ganti dengan data dan gambar yang sesuai)
        destinasiList.add(new Destinasi("Bali", "Pulau Dewata dengan pantai indah, budaya yang kaya, dan pemandangan alam yang memukau.", R.drawable.img_bali));
        destinasiList.add(new Destinasi("Raja Ampat", "Surga bawah laut dengan keanekaragaman biota laut terkaya di dunia.", R.drawable.img_rajaampat)); // Ganti dengan gambar Raja Ampat
        destinasiList.add(new Destinasi("Kepulauan Seribu", "Kepulauan yang di provinsi Jakarta dengan pemandangan yang sangat indah.", R.drawable.img_kepulauanseribu)); // Ganti dengan gambar Yogyakarta
        destinasiList.add(new Destinasi("Lombok", "Pesona Gili dan Gunung Rinjani yang menawarkan petualangan alam.", R.drawable.img_lombok)); // Ganti dengan gambar Lombok
        destinasiList.add(new Destinasi("Labuan Bajo", "Rumah bagi Komodo dan pantai Pink yang menakjubkan.", R.drawable.img_labuanbajo)); // Ganti dengan gambar Labuan Bajo
        destinasiList.add(new Destinasi("Karimun Jawa", "Pulau-pulau dengan pemandangan yang indah yang sangat memanjakan mata manusia", R.drawable.img_karimunjawa)); // Ganti dengan gambar Danau Toba
    }
}