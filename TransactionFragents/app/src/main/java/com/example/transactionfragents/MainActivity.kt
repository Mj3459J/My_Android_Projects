package com.example.transactionfragents

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav=findViewById(R.id.bottom_nav)

        val chatFrag=Chat()
        val callFrag=Call()
        val profileFrag=Profile()

        val fragmentManager=supportFragmentManager.beginTransaction()

        bottomNav.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.chat_menu->fragmentManager.replace(R.id.fragContainer,chatFrag)
                R.id.profile_menu->fragmentManager.replace(R.id.fragContainer,profileFrag)
                R.id.call_menu->fragmentManager.replace(R.id.fragContainer,callFrag)
            }
            true
        }
    }
}