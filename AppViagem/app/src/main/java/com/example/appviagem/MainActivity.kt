package com.example.appviagem


import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listViewDestinos)

        val destinos = arrayListOf(
            Destino("Paris", "A cidade da luz, famosa pela Torre Eiffel.", R.drawable.paris),
            Destino("Tailândia", "Chamada de Terra dos Sorrisos.", R.drawable.tailandia),
            Destino("Vancouver", "Conhecida por sua beleza natural.", R.drawable.vancouver),
            Destino("Tóquio", "Tecnologia, cultura e tradição japonesa.", R.drawable.tokio),
            Destino("Índia", "Cultura rica e diversificada", R.drawable.india),
            Destino("Londres", "A terra da rainha.", R.drawable.londres)
        )

        val adapter = Adapter(this, destinos)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val destino = destinos[position]

            val intent = Intent(this, DetalheActivity::class.java)
            intent.putExtra("nome", destino.nome)
            intent.putExtra("descricao", destino.descricao)
            intent.putExtra("imagem", destino.imagem)

            startActivity(intent)
        }
    }
}