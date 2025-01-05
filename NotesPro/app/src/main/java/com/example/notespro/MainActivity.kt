package com.example.notespro

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference



class MainActivity : AppCompatActivity() {
    lateinit var firedb: FirebaseDatabase
    lateinit var dbref: DatabaseReference
    lateinit var title: TextInputEditText
    lateinit var write: TextInputEditText
    lateinit var addBtn: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        firedb = FirebaseDatabase.getInstance()
        dbref = firedb.getReference("AllNotes")

        title = findViewById(R.id.TitleText)
        write = findViewById(R.id.TitleText)
        addBtn = findViewById(R.id.btn)

        val hashmap = HashMap<String, String>()
        addBtn.setOnClickListener {
            val title1 = title.text.toString()
            val data1 = write.text.toString()
            hashmap.put("Title", title1)
            hashmap.put("Data", data1)

            dbref.push().setValue(hashmap).addOnSuccessListener {
                Toast.makeText(this@MainActivity, "Data Added", Toast.LENGTH_SHORT).show()
            }

        }
    }
}