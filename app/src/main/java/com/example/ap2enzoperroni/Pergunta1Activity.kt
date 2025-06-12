package com.example.ap2enzoperroni

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Pergunta1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pergunta1)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup1)
        val rbMagia = findViewById<RadioButton>(R.id.rbMagia)
        val rbForca = findViewById<RadioButton>(R.id.rbForca)
        val rbSuporte = findViewById<RadioButton>(R.id.rbSuporte)
        val btnNext = findViewById<Button>(R.id.btnNext1)

        // Forçar exclusividade manualmente
        val radioButtons = listOf(rbMagia, rbForca, rbSuporte)

        radioButtons.forEach { selected ->
            selected.setOnClickListener {
                radioButtons.forEach { it.isChecked = it == selected }
            }
        }

        btnNext.setOnClickListener {
            val selected = radioButtons.find { it.isChecked }?.text.toString()
            val name = intent.getStringExtra("USER_NAME")

            if (selected.isBlank()) {
                Toast.makeText(this, "Selecione uma opção!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, Pergunta2Activity::class.java)
            intent.putExtra("USER_NAME", name)
            intent.putExtra("ESTILO_JOGO", selected)
            startActivity(intent)
        }
    }
}
