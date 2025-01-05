package com.example.volumecalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class CubeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cube)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textView: TextView =findViewById(R.id.cubeText)
        val editText: TextInputEditText =findViewById(R.id.editText)
        val result: TextView =findViewById(R.id.resultText)
        val calcBtn: MaterialButton =findViewById(R.id.calculateBtn)

        calcBtn.setOnClickListener {
            val length=editText.text.toString()
            val l=Integer.parseInt(length)

            val volume=l*l*l


            result.text="V= $volume m^3"
        }
    }
}