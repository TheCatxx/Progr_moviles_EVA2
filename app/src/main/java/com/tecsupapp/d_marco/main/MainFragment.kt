package com.tecsupapp.d_marco.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tecsupapp.d_marco.R
import com.tecsupapp.d_marco.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: AppCompatActivity(){

    private val listPlatillos = listOf(
        Platillos(R.drawable.imagen1, "Pizza DMarco", "Pizzas", "S/. 25.00", "La mejor pizza con la combinacion perfecta de queso, espinaca y carnes del norte trujillano" ),
        Platillos(R.drawable.imagen2, "Duo DMarco", "Bebidas", "S/. 15.00", "La combinacion perfecta para compartir entre amigos" ),
        Platillos(R.drawable.imagen3, "Cafe", "Bebidas", "S/. 10.00", "Los mejores granos del norte peruano solo en DMarco" ),
        Platillos(R.drawable.imagen4, "Pan con pollo", "Sanguches", "S/. 15.00", "El tradicional pan con pollo trujillano, solo en DMarco" ),
        Platillos(R.drawable.imagen5, "Ceviche DMarco", "Pescados y mariscos", "S/. 25.00", "La mejor en ceviche mixto  con el tradicional toque Trujillano, solo en DMarco") ,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
        title = "Platos D'Marco"

        recyclerCatalago.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = PlatilloAdapter(listPlatillos)
        }

        floatingNotify.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

}