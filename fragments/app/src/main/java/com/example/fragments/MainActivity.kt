package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

val data= arrayOf("Chats","Calls","Status")
class MainActivity : AppCompatActivity() {
    lateinit var tabLayout:TabLayout
    lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tabLayout=findViewById(R.id.tabLayout)
        viewPager2=findViewById(R.id.viewPager)

        val adapter=MyAdapter(supportFragmentManager,lifecycle)
        viewPager2.adapter=adapter

        TabLayoutMediator(tabLayout,viewPager2)
        {
                tab,position->
            tab.text=data[position]
        }.attach()
    }
}