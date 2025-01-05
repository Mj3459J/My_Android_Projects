package com.example.volumecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SphereActivity : AppCompatActivity() {
    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sphere)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textView:TextView=findViewById(R.id.sphereText)
        val editText:TextInputEditText=findViewById(R.id.editText)
        val result:TextView=findViewById(R.id.resultText)
        val calcBtn:MaterialButton=findViewById(R.id.calculateBtn)

        calcBtn.setOnClickListener {
            val radius=editText.text.toString()
            val r=Integer.parseInt(radius)

            val volume=(4/3)*Math.PI* r*r*r
            val v=String.format("%.2f",volume)

            result.text="V= $v m^3"
        }


    }

}