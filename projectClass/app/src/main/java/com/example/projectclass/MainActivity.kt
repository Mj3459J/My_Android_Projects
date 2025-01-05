package com.example.projectclass

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var btn:MaterialButton
    lateinit var name:TextInputEditText
    lateinit var pass:TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myinit()

        btn.setOnClickListener {
            val name_data=name.text.toString().trim()
            val pass_data=pass.text.toString().trim()

            val intent=Intent(this@MainActivity,HomeScreenActivity::class.java)
            intent.putExtra("Name101",name_data)
            intent.putExtra("Pass101",pass_data)
            startActivity(intent)
            finish()
        }
    }
    private fun myinit(){
        btn=findViewById(R.id.btn1)
        name=findViewById(R.id.name_box1)
        pass=findViewById(R.id.name_box2)

    }
}