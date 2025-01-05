package com.example.volumecalculator

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
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
        // step 1 GridView
        val gridView:GridView=findViewById(R.id.GridView)

        //step 2 Data source
        val shape1:Shape=Shape(R.drawable.sphere,"Sphere")
        val shape2:Shape=Shape(R.drawable.cube,"Cube")
        val shape3:Shape=Shape(R.drawable.prism,"Prism")
        val shape4:Shape=Shape(R.drawable.cylinder,"Cylinder")

        val gridItems=listOf<Shape>(shape1,shape2,shape3,shape4)

        //step 3 Adapter
        val myAdapter=MyCustomAdapter(this,gridItems)
        gridView.adapter=myAdapter

        //Handling the click events
        gridView.setOnItemClickListener { _, _, position, _ ->
            val clickedItem=myAdapter.getItem(position)

            if(clickedItem?.shapeName.equals("Sphere")){
                val i=Intent(this,SphereActivity::class.java)
                startActivity(i)
            }
            else if(clickedItem?.shapeName.equals("Cube")){
                val i=Intent(this,CubeActivity::class.java)
                startActivity(i)
            }
            else if(clickedItem?.shapeName.equals("Prism")){
                val i=Intent(this,PrismActivity::class.java)
                startActivity(i)
            }
           else{
                val i=Intent(this,CylinderActivity::class.java)
                startActivity(i)
            }
        }
    }
}