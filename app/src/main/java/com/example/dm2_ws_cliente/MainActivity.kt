package com.example.dm2_ws_cliente

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAtualizar.setOnClickListener {
            chamarWSDataHora()
        }

    }

    fun chamarWSDataHora() {
        val dt_hora = WSCliente().dataHora()
        txtHora.text = dt_hora
    }
}