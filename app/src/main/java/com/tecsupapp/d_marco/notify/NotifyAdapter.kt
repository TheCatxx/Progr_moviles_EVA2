package com.tecsupapp.d_marco.notify

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tecsupapp.d_marco.model.Notify

class NotifyAdapter(val mItemClickListener: ItemClickListener): RecyclerView.Adapter<NotifyViewHolder>() {

    private var notifyList = emptyList<Notify>()


    fun setNotifys(notifis: List<Notify>) {
        this.notifyList = notifis
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = notifyList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return  NotifyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NotifyViewHolder, position: Int) {
        val notify: Notify = notifyList[position]
        holder.bind(notify)
        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(notify)
        }
    }

    interface ItemClickListener {
        fun onItemClick(notify: Notify)
    }

}