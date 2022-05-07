package com.tecsupapp.d_marco.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tecsupapp.d_marco.R
import com.tecsupapp.d_marco.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val actionBar = supportActionBar
        actionBar?.hide()

        btnIngresar.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}