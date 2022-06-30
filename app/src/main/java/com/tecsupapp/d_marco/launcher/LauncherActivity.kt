package com.tecsupapp.d_marco.launcher

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.tecsupapp.d_marco.R
import com.tecsupapp.d_marco.login.LoginActivity

class LauncherActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val actionBar = supportActionBar
        actionBar?.hide()


        Handler(Looper.getMainLooper()).
        postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 6000)


        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.v("FIREBASE_MESSAGING","Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            Log.v("FIREBASE_MESSAGING", "New Token: $token")
        })
    }
}