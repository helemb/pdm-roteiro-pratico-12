package com.example.appviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destino)

        val img = findViewById<ImageView>(R.id.imgDetalhe)
        val nome = findViewById<TextView>(R.id.txtNomeDetalhe)
        val descricao = findViewById<TextView>(R.id.txtDescricaoDetalhe)

        val nomeRecebido = intent.getStringExtra("nome")
        val descRecebida = intent.getStringExtra("descricao")
        val imagemRecebida = intent.getIntExtra("imagem", 0)

        nome.text = nomeRecebido
        descricao.text = descRecebida
        img.setImageResource(imagemRecebida)
    }
}