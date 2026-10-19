package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNama = findViewById<EditText>(R.id.inputNama)
        val inputNim = findViewById<EditText>(R.id.inputNim)
        val btnTampilkan = findViewById<Button>(R.id.btnTampilkan)
        val layoutOutput = findViewById<LinearLayout>(R.id.layoutOutput)
        val tvOutputNama = findViewById<TextView>(R.id.tvOutputNama)
        val tvOutputNim = findViewById<TextView>(R.id.tvOutputNim)
        val btnBukaLogin = findViewById<Button>(R.id.btnBukaLogin)
        val btnBukaSeragam = findViewById<Button>(R.id.btnBukaSeragam)

        btnTampilkan.setOnClickListener {
            val nama = inputNama.text.toString()
            val nim = inputNim.text.toString()

            if (nama.isNotEmpty() && nim.isNotEmpty()) {
                tvOutputNama.text = "Halo $nama!"
                tvOutputNim.text = "NIM Anda: $nim"
                layoutOutput.visibility = View.VISIBLE
            }
        }

        btnBukaLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnBukaSeragam.setOnClickListener {
            val intent = Intent(this, SeragamActivity::class.java)
            startActivity(intent)
        }
    }
}
