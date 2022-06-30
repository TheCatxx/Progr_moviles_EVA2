package com.tecsupapp.d_marco.home

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tecsupapp.d_marco.R
import com.tecsupapp.d_marco.main.PlatilloAdapter
import com.tecsupapp.d_marco.main.Platillos
import com.tecsupapp.d_marco.notify.NotifyFragment
import kotlinx.android.synthetic.main.fragment_main.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val actionBar = supportActionBar
        actionBar?.hide()


        openFragment(NotifyFragment.newInstance())

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