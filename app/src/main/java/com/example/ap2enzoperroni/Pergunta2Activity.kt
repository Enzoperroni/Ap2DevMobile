package com.example.ap2enzoperroni

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class Pergunta2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pergunta2)

        val cb1 = findViewById<CheckBox>(R.id.cbInteligente)
        val cb2 = findViewById<CheckBox>(R.id.cbCorajoso)
        val cb3 = findViewById<CheckBox>(R.id.cbAltruista)
        val btnNext = findViewById<Button>(R.id.btnNext2)

        btnNext.setOnClickListener {
            val qualidades = mutableListOf<String>()
            if (cb1.isChecked) qualidades.add("Inteligente")
            if (cb2.isChecked) qualidades.add("Corajoso")
            if (cb3.isChecked) qualidades.add("Altruísta")

            val name = intent.getStringExtra("USER_NAME")
            val estilo = intent.getStringExtra("ESTILO_JOGO")

            val intent = Intent(this, Pergunta3Activity::class.java)
            intent.putExtra("USER_NAME", name)
            intent.putExtra("ESTILO_JOGO", estilo)
            intent.putStringArrayListExtra("QUALIDADES", ArrayList(qualidades))
            startActivity(intent)
        }
    }
}