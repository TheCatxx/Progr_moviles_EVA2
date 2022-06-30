package com.tecsupapp.d_marco.notify

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsupapp.d_marco.R
import com.tecsupapp.d_marco.model.Notify

class NotifyViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_notify, parent, false)) {
    private var textDateTime: TextView? = null
    private var textNotifyTitle: TextView? = null
    private var textNotifyContent: TextView? = null

    init {
        textDateTime = itemView.findViewById(R.id.textDate)
        textNotifyTitle = itemView.findViewById(R.id.textTitle)
        textNotifyContent = itemView.findViewById(R.id.textContent)
    }

    fun bind(notify: Notify) {
        textDateTime?.text = notify.date
        textNotifyTitle?.text = notify.title
        textNotifyContent?.text = notify.content

    }
}