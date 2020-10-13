package com.example.lab3task2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.mtoolbar)
        setSupportActionBar(toolbar)

        val drawer: DrawerLayout = findViewById(R.id.mdrawer_layout)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navView: NavigationView = findViewById(R.id.mnav_view)
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mnav_about -> {
                    val drawerL: DrawerLayout = findViewById(R.id.mdrawer_layout)
                    drawerL.closeDrawer(GravityCompat.START)

                    startActivity(Intent(this, AboutActivity::class.java))
                    true
                }
                else -> false
            }
        }
        navView.bringToFront()
    }

    fun onClick12(view: View) {
        startActivity(Intent(this, SecondActivity::class.java))
    }

    override fun onBackPressed() {
        val drawer: DrawerLayout = findViewById(R.id.mdrawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}