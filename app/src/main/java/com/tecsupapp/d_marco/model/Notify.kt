package com.tecsupapp.d_marco.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notify_table")
data class Notify (

    @ColumnInfo(name = "date_notify")
    val date: String,

    @ColumnInfo(name = "title_notify")
    val title: String,

    @ColumnInfo(name = "content_notify")
    val content: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "notify_id")
    var notifyID: Int = 0
}