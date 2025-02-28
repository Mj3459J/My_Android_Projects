package com.example.viewpagerandtablayout

import MyPagerAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    // Declaring Views.
    lateinit var viewPager2: ViewPager2
    lateinit var myAdapter: MyPagerAdapter
    lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Initialize ViewPager.
        viewPager2=findViewById(R.id.viewPager2)
        viewPager2.orientation=ViewPager2.ORIENTATION_HORIZONTAL

        // Add fragments to the list in the adapter class.
        myAdapter=MyPagerAdapter(supportFragmentManager,lifecycle)
        myAdapter.addFragmentToList(Html())
        myAdapter.addFragmentToList(Css())
        myAdapter.addFragmentToList(JavaScript())

        // Connecting the adapter with ViewPager2.
        viewPager2.adapter=myAdapter

        // Connecting tabLayout with viewPAger2.
        tabLayout=findViewById(R.id.tabLayout)
        val tabTitles= arrayOf("HTML","CSS","JavaScript")
        TabLayoutMediator(tabLayout,viewPager2){
            tab,position -> tab.text=tabTitles[position]
        }.attach()


    }
}