package com.tecsupapp.d_marco.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.tecsupapp.d_marco.MapsActivity
import com.tecsupapp.d_marco.R
import com.tecsupapp.d_marco.main.MainFragment
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val actionBar = supportActionBar
        actionBar?.hide()

        MobileAds.initialize(this)
        val adRequest = AdRequest.Builder().build()

        //BANNER
        adViewBanner.loadAd(adRequest)

        btnIngresar.setOnClickListener {
            startActivity(Intent(this, MainFragment::class.java))
        }

        fbMaps.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }

    }
}