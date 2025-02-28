package com.example.freshapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottom:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        bottom=findViewById(R.id.bottom_nav)
        val add=AddData()
        val show=ShowData()

        val fragManager=supportFragmentManager.beginTransaction()
        fragManager.replace(R.id.fragContainer,AddData()).commit()

        bottom.setOnItemSelectedListener {
            val trs=supportFragmentManager.beginTransaction()

            when(it.itemId) {
                R.id.addData -> trs.replace(R.id.fragContainer, add).commit()
                R.id.showData -> trs.replace(R.id.fragContainer, show).commit()
            }
            true
        }
    }
}