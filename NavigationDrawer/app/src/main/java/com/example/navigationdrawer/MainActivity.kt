package com.example.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout=findViewById(R.id.drawerLayout)


        toggle=ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            toolbar,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // now adding functionalities
        val navView:NavigationView=findViewById(R.id.navView)
        navView.setNavigationItemSelectedListener {
            it.isChecked=true
            when(it.itemId){
                R.id.home->{replaceFragment(HomeFragment(),it.title.toString())}
                R.id.message->{replaceFragment(MessageFragment(),it.title.toString())}
                R.id.settings->{replaceFragment(SettingsFragment(),it.title.toString())}
                R.id.login->{replaceFragment(LoginFragment(),it.title.toString())}
            }
            true
        }
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment(), "Home")
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment:Fragment,title:String){
        val fragmentManager=supportFragmentManager
        val fragTransaction=fragmentManager.beginTransaction()
        fragTransaction.replace(R.id.frameLayout1,fragment)
        fragTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }
}