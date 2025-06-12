package com.example.ap2enzoperroni

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Pergunta3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pergunta3) // Just contains the FrameLayout

        if (savedInstanceState == null) {
            val fragment = Pergunta3Fragment().apply {
                arguments = intent.extras
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }
}
