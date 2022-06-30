package com.tecsupapp.d_marco.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.tecsupapp.d_marco.R
import com.tecsupapp.d_marco.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: AppCompatActivity(){

    //AdMod

    // Interstitial
    var mInterstitialAd: InterstitialAd? = null

    //RewardedAd
    var mRewardedAd: RewardedAd? = null


    private val listPlatillos = listOf(
        Platillos(R.drawable.imagen1, "Pizza DMarco", "Pizzas", "S/. 25.00", "La mejor pizza con la combinacion perfecta de queso, espinaca y carnes del norte trujillano" ),
        Platillos(R.drawable.imagen2, "Duo DMarco", "Bebidas", "S/. 15.00", "La combinacion perfecta para compartir entre amigos" ),
        Platillos(R.drawable.imagen3, "Cafe", "Bebidas", "S/. 10.00", "Los mejores granos del norte peruano solo en DMarco" ),
        Platillos(R.drawable.imagen4, "Pan con pollo", "Sanguches", "S/. 15.00", "El tradicional pan con pollo trujillano, solo en DMarco" ),
        Platillos(R.drawable.imagen5, "Ceviche DMarco", "Pescados y mariscos", "S/. 25.00", "La mejor en ceviche mixto  con el tradicional toque Trujillano, solo en DMarco") ,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
        title = "Platos D'Marco"

        recyclerCatalago.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = PlatilloAdapter(listPlatillos)
        }

        floatingNotify.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }


        // Interstitial
        MobileAds.initialize(this)

        val adRequest = AdRequest.Builder().build()
        //BANNER
        //adViewBanner.loadAd(adRequest)

        //Interstitial
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712",
            adRequest, object : InterstitialAdLoadCallback(){
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.v("ADS_ADMOB", "Intersticial  - ERROR")
                    Log.v("ADS_ADMOB", adError.message)
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.v("ADS_ADMOB", "Intersticial  - SUCCESS")
                    mInterstitialAd = interstitialAd
                }
            })

        fabInterstitial.setOnClickListener{
            if (mInterstitialAd != null){
                mInterstitialAd?.show(this)
            } else{
                Log.v("ADS_ADMOB", "Intersticial  - NO ESTA INICIALIZADO")
            }
        }

        //RewardedAd
        val adRequesst = AdRequest.Builder().build()
        //Inicializar la libreria


        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
            adRequesst, object : RewardedAdLoadCallback(){
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    mRewardedAd = null
                }

                override fun onAdLoaded(rewardedAd: RewardedAd) {
                    mRewardedAd = rewardedAd
                }
            })

        fabBonification.setOnClickListener {
            if (mRewardedAd != null) {
                mRewardedAd?.show(this) {
                    fun onUserEarnedReward(rewardItem: RewardItem) {
                        var rewardAmount = rewardItem.amount
                        var rewardType = rewardItem.type
                        Log.v("ADS_BONIFICADO", rewardAmount.toString())
                        Log.v("ADS_BONIFICADO", rewardType)
                    }
                }
            } else {
                Log.v("ADS_BONIFICADO", "ERROR")
            }
        }

    }

}