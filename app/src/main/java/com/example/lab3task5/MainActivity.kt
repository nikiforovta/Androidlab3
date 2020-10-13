package com.example.lab3task5

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_third.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration =
            AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun onClick(view: View) {
        when (view.id) {
            bn12?.id -> navController.navigate(R.id.first_to_second)
            bn23?.id -> navController.navigate(R.id.second_to_third)
            bn21?.id -> navController.navigate(R.id.second_to_first)
            bn31?.id -> navController.navigate(R.id.third_to_first)
            bn32?.id -> navController.navigate(R.id.third_to_second)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}