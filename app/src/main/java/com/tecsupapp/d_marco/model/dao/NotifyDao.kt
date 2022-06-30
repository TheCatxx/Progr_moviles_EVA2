package com.tecsupapp.d_marco.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tecsupapp.d_marco.model.Notify

@Dao
interface NotifyDao {

    @Insert
    fun insert(notify: Notify)

    @Update
    fun update(notify: Notify)

    @Delete
    fun delete(notify: Notify)

    @Query("SELECT * FROM notify_table ORDER BY date_notify DESC")
    fun getListNotify(): LiveData<List<Notify>>

    @Query("UPDATE notify_table SET title_notify=:title, content_notify=:content WHERE notify_id=:id")
    fun update(title: String, content: String, id: Int)
}