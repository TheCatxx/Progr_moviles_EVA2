package com.tecsupapp.d_marco

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.tecsupapp.d_marco.model.Notify
import com.tecsupapp.d_marco.notify.NotifyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MyFireBaseMessagingService: FirebaseMessagingService(){

    //PARA GUARDAR - LAB12

    /*
    private val repository = NotifyRepository(application)
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    */

    //RECIBIMOS EL CONTENIDO DE LA NOTIFICACION

    override fun onMessageReceived(message: RemoteMessage) {
        createNotificationChannel()
        Log.v("FIREBASE_MESSAGING", "Fom: ${message.from}")
        Log.v("FIREBASE_MESSAGING", "Fom: ${message.data}")
        Log.v("FIREBASE_MESSAGING", "Fom: ${message.notification}")


        val titulo = message.data["titulo"]
        val mensaje = message.data["mensaje"]

        val dateNote = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        Log.v("FIREBASE_MESSAGING", "Fecha: ${dateNote}")


        showNotify(titulo, mensaje)
        /*
        var notify = Notify(dateNote, titulo.toString(), mensaje.toString())

        scope.launch {
            repository.insertNotifyWithCoroutines(notify)
        }
         */

    }


    //Genramos el token del dispositvo
    override fun onNewToken(token: String) {
        Log.v("FIREBASE_MESSAGING", "New Token: $token")
    }


    fun showNotify(titulo: String?, contenido:String?){
        val notification = NotificationCompat.Builder(this,getString(R.string.channel_id)).also {
            it.setContentTitle(titulo)
            it.setContentText(contenido)
            it.setSmallIcon(R.drawable.ic_baseline_food_bank_24)
            it.color = Color.YELLOW
            it.priority = NotificationCompat.PRIORITY_HIGH
        }.build()

        val notificationManager: NotificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManager.notify(1, notification)

    }

    private fun createNotificationChannel() {
        val name = getString(R.string.channel_name)
        val descriptionText = getString(R.string.channel_description)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(getString(R.string.channel_id), name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

    }

}