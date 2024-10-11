package com.example.desafio3_dsm


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecursoAdapter(private val recursos: List<Recurso>) : RecyclerView.Adapter<RecursoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.tvTitulo)
        val descripcion: TextView = view.findViewById(R.id.tvDescripcion)
        val tipo: TextView = view.findViewById(R.id.tvTipo)  // Cambia el nombre a 'tipo'
        val enlace: TextView = view.findViewById(R.id.tvEnlace)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recurso, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recurso = recursos[position]
        holder.titulo.text = recurso.Titulo
        holder.descripcion.text = recurso.Descripcion
        holder.tipo.text = recurso.Tipo // Asumiendo que la clase Recurso tiene un campo Tipo
        holder.enlace.text = recurso.Enlace
    }

    override fun getItemCount(): Int = recursos.size
}

