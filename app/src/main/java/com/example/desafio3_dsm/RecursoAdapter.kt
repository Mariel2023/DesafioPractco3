package com.example.desafio3_dsm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.listaRecursos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        obtenerRecursos()

        findViewById<Button>(R.id.btnBuscar).setOnClickListener {
            val id = findViewById<EditText>(R.id.inputId).text.toString()
            buscarRecurso(id)
        }

        findViewById<Button>(R.id.btnAgregar).setOnClickListener {
            agregarRecurso()
        }

        findViewById<Button>(R.id.btnModificar).setOnClickListener {
            modificarRecurso()
        }

        findViewById<Button>(R.id.btnEliminar).setOnClickListener {
            eliminarRecurso()
        }
    }

    private fun obtenerRecursos() {
        CoroutineScope(Dispatchers.IO).launch {
            val recursos = RetrofitClient.instance.getRecursos()
            runOnUiThread {
                recyclerView.adapter = RecursoAdapter(recursos)
            }
        }
    }

    private fun buscarRecurso(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val recurso = RetrofitClient.instance.getRecursoById(id)
            runOnUiThread {
                Toast.makeText(this@MainActivity, "Recurso encontrado: ${recurso.Titulo}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun agregarRecurso() {
        // Lógica para agregar recurso con Retrofit y mostrar notificación Toast
    }

    private fun modificarRecurso() {
        // Lógica para modificar recurso con Retrofit y mostrar notificación Toast
    }

    private fun eliminarRecurso() {
        // Lógica para eliminar recurso con Retrofit y mostrar notificación Toast
    }
}
