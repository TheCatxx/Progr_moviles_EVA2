package com.tecsupapp.d_marco.launcher

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
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

    }
}