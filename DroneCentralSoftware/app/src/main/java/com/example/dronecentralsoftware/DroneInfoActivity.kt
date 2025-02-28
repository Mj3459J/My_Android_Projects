package com.example.dronecentralsoftware


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.material.card.MaterialCardView

class DroneInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drone_info)

        // Dummy Data (Replace this with actual data from Firebase or API later)
        val batteryLife = "85%" // Example battery percentage
        val wentTime = "10:30 AM" // Time when drone took off
        val reachingTime = "11:15 AM" // Expected reaching time
        val droneCondition = "Good" // Condition (Good/Poor)

        // Set data in UI
        findViewById<TextView>(R.id.txtBatteryLife).text = batteryLife
        findViewById<TextView>(R.id.txtWentTime).text = wentTime
        findViewById<TextView>(R.id.txtReachingTime).text = reachingTime
        findViewById<TextView>(R.id.txtDroneCondition).text = droneCondition
    }
}
