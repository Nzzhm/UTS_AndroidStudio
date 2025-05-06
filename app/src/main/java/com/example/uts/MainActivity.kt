package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnToLogin()
    }

    private fun btnToLogin(){

        val btnAwal = findViewById<Button>(R.id.btn_awal)

        btnAwal.setOnClickListener{
            startActivity(Intent(this, LogInActivity::class.java))
        }
    }
}