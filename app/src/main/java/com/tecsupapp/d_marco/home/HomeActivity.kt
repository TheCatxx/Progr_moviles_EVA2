package com.tecsupapp.d_marco.home

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tecsupapp.d_marco.R
import com.tecsupapp.d_marco.main.MainFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        title = "Platos D'Marco"

        openFragment(MainFragment.newInstance())

    }

    override fun onCreateOptionsMenu(menu: Menu):Boolean{
        menuInflater.inflate(R.menu.appbar_menu, menu)
        return true
    }

    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContent, fragment)
        transaction.commit()
    }
}