package com.example.userregistration

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var fireobject:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val email:TextView=findViewById(R.id.inp_email)
        val pass:TextView=findViewById(R.id.inp_password)
        val cnf_pass:TextView=findViewById(R.id.inp_cnf_password)
        val btn:MaterialButton=findViewById(R.id.btn_submit)

        btn.setOnClickListener {
            val email_data=email.text.toString().trim()
            val pass_data=pass.text.toString().trim()
            val cnf_pass_data=cnf_pass.text.toString().trim()
            if(pass_data.equals(cnf_pass_data)){
                fireobject.createUserWithEmailAndPassword(email_data,pass_data)
            }
        }
    }
}