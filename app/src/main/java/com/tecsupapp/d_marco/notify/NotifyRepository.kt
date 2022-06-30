package com.tecsupapp.d_marco.notify

import android.app.Application
import androidx.lifecycle.LiveData
import com.tecsupapp.d_marco.database.DMarcoRoomDatabase
import com.tecsupapp.d_marco.model.Notify
import com.tecsupapp.d_marco.model.dao.NotifyDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotifyRepository(application: Application) {

    private val notifyDao: NotifyDao? = DMarcoRoomDatabase.getInstance(application)?.notifyDao()

    //LiveData: clase contenedora de datos observables
    fun getNotifys(): LiveData<List<Notify>>{
        return notifyDao?.getListNotify()!!
    }

    suspend fun insertNotifyWithCoroutines(notify: Notify){
        processInsertNotify(notify)
    }

    private suspend fun processInsertNotify(notify: Notify){
        withContext(Dispatchers.Default){
            notifyDao?.insert(notify)
        }
    }

    //Actualizar
    suspend fun  updateNotifyWithCoroutines(notify: Notify){
        processUpdateNotify(notify)
    }

    private suspend fun processUpdateNotify(notify: Notify){
        withContext(Dispatchers.Default){
            notifyDao?.update(notify)
        }

    }

    //Eliminar
    suspend fun  deleteNotifyWithCoroutines(notify: Notify){
        processDeleteNotify(notify)
    }
    private suspend fun processDeleteNotify(notify: Notify){
        withContext(Dispatchers.Default){
            notifyDao?.delete(notify)
        }
    }

}