package com.example.appviagem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter(
    private val context: Context,
    private val lista: List<Destino>
) : BaseAdapter() {

    override fun getCount() = lista.size
    override fun getItem(position: Int) = lista[position]
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context)
                .inflate(R.layout.destino, parent, false)

            holder = ViewHolder(
                view.findViewById(R.id.imgDetalhe),
                view.findViewById(R.id.txtNome),
                view.findViewById(R.id.txtDescricao)
            )

            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val destino = lista[position]

        holder.nome.text = destino.nome
        holder.descricao.text = destino.descricao
        holder.foto.setImageResource(destino.imagem)

        return view
    }

    class ViewHolder(
        val foto: ImageView,
        val nome: TextView,
        val descricao: TextView
    )
}

