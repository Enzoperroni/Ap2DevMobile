package com.example.ap2enzoperroni

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class Pergunta3Fragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pergunta3, container, false)

        val btnCetro = view.findViewById<ImageButton>(R.id.btnCetro)
        val btnMachado = view.findViewById<ImageButton>(R.id.btnMachado)

        btnCetro.setOnClickListener { selecionarArtefato("Cetro Místico") }
        btnMachado.setOnClickListener { selecionarArtefato("Machado Flamejante") }

        return view
    }

    private fun selecionarArtefato(artefato: String) {
        val intent = Intent(requireContext(), ResultadoActivity::class.java)
        intent.putExtras(requireArguments()) // carry previous answers
        intent.putExtra("ARTEFATO", artefato)
        startActivity(intent)
    }
}
