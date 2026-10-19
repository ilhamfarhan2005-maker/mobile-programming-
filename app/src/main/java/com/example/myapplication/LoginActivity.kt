package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.title = "Halaman Login Modern"

        val tilUsername = findViewById<TextInputLayout>(R.id.tilUsername)
        val tilPassword = findViewById<TextInputLayout>(R.id.tilPassword)
        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val cbIngatSaya = findViewById<CheckBox>(R.id.cbIngatSaya)
        val tvLupaPassword = findViewById<TextView>(R.id.tvLupaPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val btnGoogleLogin = findViewById<MaterialButton>(R.id.btnGoogleLogin)
        val tvLoginStatus = findViewById<TextView>(R.id.tvLoginStatus)
        val btnKembaliLogin = findViewById<MaterialButton>(R.id.btnKembaliLogin)

        btnLogin.setOnClickListener {
            // Reset error states
            tilUsername.error = null
            tilPassword.error = null

            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            var isValid = true

            if (username.isEmpty()) {
                tilUsername.error = "Username wajib diisi!"
                isValid = false
            }

            if (password.isEmpty()) {
                tilPassword.error = "Password wajib diisi!"
                isValid = false
            } else if (password.length < 6) {
                tilPassword.error = "Password minimal 6 karakter!"
                isValid = false
            }

            if (isValid) {
                val statusIngat = if (cbIngatSaya.isChecked) " (Ingat Saya: Aktif)" else ""
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()

                tvLoginStatus.text = "Berhasil masuk sebagai: $username$statusIngat"
                tvLoginStatus.visibility = View.VISIBLE
            }
        }

        btnGoogleLogin.setOnClickListener {
            Toast.makeText(this, "Menghubungkan ke Akun Google...", Toast.LENGTH_SHORT).show()
            tvLoginStatus.text = "Login via Google Berhasil!"
            tvLoginStatus.visibility = View.VISIBLE
        }

        tvLupaPassword.setOnClickListener {
            Toast.makeText(this, "Fitur Reset Password: Cek email Anda untuk link pemulihan.", Toast.LENGTH_LONG).show()
        }

        btnKembaliLogin.setOnClickListener {
            finish()
        }
    }
}
