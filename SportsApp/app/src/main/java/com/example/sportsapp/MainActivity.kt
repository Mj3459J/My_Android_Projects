package com.example.sportsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        var sportsList:ArrayList<SportModel> =ArrayList()

        val football:SportModel=SportModel(R.drawable.football,"Football")
        val basketball:SportModel=SportModel(R.drawable.basketball,"Basketball")
        val volleyball:SportModel=SportModel(R.drawable.volley,"Volleyball")
        val tennis:SportModel=SportModel(R.drawable.tennis,"Tennis")
        val ping:SportModel=SportModel(R.drawable.ping,"Ping")

        sportsList.add(football)
        sportsList.add(basketball)
        sportsList.add(volleyball)
        sportsList.add(tennis)
        sportsList.add(ping)

        val adapter=SportsAdapter(sportsList)
        recyclerView.adapter=adapter


    }
}