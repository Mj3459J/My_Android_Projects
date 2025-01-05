package com.example.projectclass

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeScreenActivity : AppCompatActivity() {
    lateinit var showName:TextView
    lateinit var showPass:TextView
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myInit()

        btn.setOnClickListener{
            val myintent=intent
            showName.text=myintent.getStringExtra("Name101")
            showPass.text=myintent.getStringExtra("Pass101")
        }
    }
    private fun myInit(){
        showName=findViewById(R.id.textview1)
        showPass=findViewById(R.id.textview2)
        btn=findViewById(R.id.homeBtn)
    }
}