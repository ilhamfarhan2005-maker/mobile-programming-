package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvLoginStatus = findViewById<TextView>(R.id.tvLoginStatus)
        val btnKembaliLogin = findViewById<Button>(R.id.btnKembaliLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty()) {
                etUsername.error = "Username tidak boleh kosong!"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Password tidak boleh kosong!"
                return@setOnClickListener
            }

            Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
            tvLoginStatus.text = "Berhasil masuk sebagai: $username"
            tvLoginStatus.visibility = View.VISIBLE
        }

        btnKembaliLogin.setOnClickListener {
            finish()
        }
    }
}
