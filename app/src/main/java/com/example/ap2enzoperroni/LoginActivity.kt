package com.example.ap2enzoperroni

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtName = findViewById<EditText>(R.id.edtName)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val name = edtName.text.toString()
            val intent = Intent(this, Pergunta1Activity::class.java)
            intent.putExtra("USER_NAME", name)
            startActivity(intent)
        }
    }
}