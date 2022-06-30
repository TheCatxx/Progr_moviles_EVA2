package com.tecsupapp.d_marco.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tecsupapp.d_marco.model.Notify
import com.tecsupapp.d_marco.model.dao.NotifyDao
@Database(
    entities = [Notify::class],
    version = 1,
)
abstract class DMarcoRoomDatabase : RoomDatabase() {

    abstract fun notifyDao(): NotifyDao

    companion object{
        private const val DATABASE_NAME = "dmarco_database"

        @Volatile
        private var INSTANCE: DMarcoRoomDatabase? = null
        fun getInstance(context: Context): DMarcoRoomDatabase?{
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    DMarcoRoomDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return  INSTANCE
        }
    }

}