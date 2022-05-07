package com.tecsupapp.d_marco.main

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tecsupapp.d_marco.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {

    private val listPlatillos = listOf(
        Platillos(R.drawable.imagen1, "Pizza DMarco", "Pizzas", "S/. 25.00", "La mejor pizza con la combinacion perfecta de queso, espinaca y carnes del norte trujillano" ),
        Platillos(R.drawable.imagen2, "Duo DMarco", "Bebidas", "S/. 15.00", "La combinacion perfecta para compartir entre amigos" ),
        Platillos(R.drawable.imagen3, "Cafe", "Bebidas", "S/. 10.00", "Los mejores granos del norte peruano solo en DMarco" ),
        Platillos(R.drawable.imagen4, "Pan con pollo", "Sanguches", "S/. 15.00", "El tradicional pan con pollo trujillano, solo en DMarco" ),
        Platillos(R.drawable.imagen5, "Ceviche DMarco", "Pescados y mariscos", "S/. 25.00", "La mejor en ceviche mixto  con el tradicional toque Trujillano, solo en DMarco") ,
    )

    companion object{
        fun newInstance(): MainFragment = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerCatalago.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = PlatilloAdapter(listPlatillos)
        }
    }



}