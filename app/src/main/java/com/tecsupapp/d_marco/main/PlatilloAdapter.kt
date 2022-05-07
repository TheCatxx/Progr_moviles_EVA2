package com.tecsupapp.d_marco.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PlatilloAdapter(val list: List<Platillos>): RecyclerView.Adapter<PlatilloViewHolder>() {
    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatilloViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlatilloViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PlatilloViewHolder, position: Int) {
        val platillos = list[position]
        holder.bind(platillos)
    }

}