package com.tecsupapp.d_marco.notify

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.tecsupapp.d_marco.model.Notify
import kotlinx.coroutines.launch

class NotifyViewModel(application: Application): AndroidViewModel(application) {

    private val repository = NotifyRepository(application)

    //Listado
    val notifys = repository.getNotifys()


    //Registro
    fun saveNotify(notify: Notify){
        viewModelScope.launch {
            repository.insertNotifyWithCoroutines(notify)
        }
    }

    //Actualizar
    fun updateNotify(notify: Notify){
        viewModelScope.launch {
            repository.updateNotifyWithCoroutines(notify)
        }
    }

    //Eliminar
    fun deleteNotify(notify: Notify){
        viewModelScope.launch {
            repository.deleteNotifyWithCoroutines(notify)
        }
    }

}