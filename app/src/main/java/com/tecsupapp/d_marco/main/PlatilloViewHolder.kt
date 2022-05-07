package com.tecsupapp.d_marco.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsupapp.d_marco.R

class PlatilloViewHolder(inflater: LayoutInflater, parent:ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_catalogo, parent, false)){

    private var imgItem: ImageView? = null
    private var textTitle: TextView? = null
    private var textCategory: TextView? = null
    private var textPrecio: TextView? = null
    private var textDescription: TextView? = null

    init {
        imgItem = itemView.findViewById(R.id.imgItem)
        textTitle = itemView.findViewById(R.id.textTitle)
        textCategory = itemView.findViewById(R.id.textCategory)
        textPrecio = itemView.findViewById(R.id.textPrecio)
        textDescription = itemView.findViewById(R.id.textDescription)
    }

    fun bind(platillos: Platillos){
        imgItem?.setImageResource(platillos.image)
        textTitle?.text = platillos.title
        textCategory?.text = platillos.category
        textPrecio?.text = platillos.precio.toString()
        textDescription?.text = platillos.description
    }

}

