package com.example.ap2enzoperroni

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val imgPersonagem = findViewById<ImageView>(R.id.imgPersonagem)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnRestart = findViewById<Button>(R.id.btnRestart)

        val nome = intent.getStringExtra("USER_NAME")
        val estilo = intent.getStringExtra("ESTILO_JOGO")
        val qualidades = intent.getStringArrayListExtra("QUALIDADES")?.joinToString(", ")
        val artefato = intent.getStringExtra("ARTEFATO")

        val personagemNome: String
        val personagemImagemResId: Int
        Log.d("ResultadoActivity", "Estilo recebido: $estilo")
        when (estilo) {
            "Magia e Controle" -> {
                personagemNome = "Invoker"
                personagemImagemResId = R.drawable.invoker
            }
            "Força Bruta" -> {
                personagemNome = "Axe"
                personagemImagemResId = R.drawable.axe
            }
            "Agilidade e Destreza" -> {
                personagemNome = "Phantom Assassin"
                personagemImagemResId = R.drawable.phantomassasin
            }
            else -> {
                personagemNome = "Desconhecido"
                personagemImagemResId = R.drawable.invoker // fallback
            }
        }

        val resultado = "$nome, com estilo $estilo,\nqualidades: $qualidades,\nartefato: $artefato\n\nVocê é o $personagemNome!"
        txtResultado.text = resultado
        imgPersonagem.setImageResource(personagemImagemResId)


        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Meu Resultado no Quiz Dota 2")
                putExtra(Intent.EXTRA_TEXT, resultado)
            }
            startActivity(Intent.createChooser(emailIntent, "Enviar E-mail"))
        }

        btnRestart.setOnClickListener {
            val intent = Intent(this, Pergunta1Activity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
