package com.example.lab3task2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val toolbar: Toolbar = findViewById(R.id.stoolbar)
        setSupportActionBar(toolbar)

        val drawer: DrawerLayout = findViewById(R.id.sdrawer_layout)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navView: NavigationView = findViewById(R.id.snav_view)
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.snav_about -> {
                    val drawerL: DrawerLayout = findViewById(R.id.sdrawer_layout)
                    drawerL.closeDrawer(GravityCompat.START)

                    startActivity(Intent(this, AboutActivity::class.java))
                    true
                }
                else -> false
            }
        }
        navView.bringToFront()
    }

    fun onClick21() {
        finish()
    }

    override fun onBackPressed() {
        val drawer: DrawerLayout = findViewById(R.id.sdrawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun onClick23() {
        startActivityForResult(Intent(this, ThirdActivity::class.java), Activity.RESULT_FIRST_USER)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == requestCode) finish()
        super.onActivityResult(requestCode, resultCode, data)
    }
}