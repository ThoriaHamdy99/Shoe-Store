package com.example.android.shoe_store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android.shoe_store.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityBinding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)

        mainActivityBinding.toolbar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.welcomeFragmentNav -> {
                    mainActivityBinding.toolbar.visibility = View.VISIBLE
                    mainActivityBinding.toolbar.navigationIcon = null
                }
                R.id.instructionsFragmentNav -> {
                    mainActivityBinding.toolbar.navigationIcon = null
                }
            }
        }
    }
}