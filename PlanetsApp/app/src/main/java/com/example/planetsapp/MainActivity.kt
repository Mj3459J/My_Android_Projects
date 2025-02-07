package com.example.planetsapp

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /* 1-The view : ListView */
        val listView:ListView=findViewById(R.id.listView)

        /* 2- Data Source :List<Planet> */
        val planet1=Planet("Mercury","0 Moons",R.drawable.mercury)
        val planet2=Planet("Venus","0 Moons",R.drawable.venus)
        val planet3=Planet("Earth","1 Moons",R.drawable.earth)
        val planet4=Planet("Mars","2 Moons",R.drawable.mars)
        val planet5=Planet("Jupiter","79 Moons",R.drawable.jupiter)
        val planet6=Planet("Saturn","83 Moons",R.drawable.saturn)
        val planet7=Planet("Uranus","27 Moons",R.drawable.uranus)
        val planet8=Planet("Neptune","14 Moons",R.drawable.neptune)
        val planet9=Planet("Pluto","5 Moons",R.drawable.pluto)

        val planetList=ArrayList<Planet>()
        planetList.add(planet1)
        planetList.add(planet2)
        planetList.add(planet3)
        planetList.add(planet4)
        planetList.add(planet5)
        planetList.add(planet6)
        planetList.add(planet7)
        planetList.add(planet8)
        planetList.add(planet9)

        /* 3- Adapter */
        val myAdapter=MyCustomAdapter(this,planetList)
        listView.adapter=myAdapter
    }
}