package com.castprogramms.bonchrestaurant.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.castprogramms.bonchrestaurant.Greeting
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.castprogramms.bonchrestaurant.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.findNavController()
        navController = findNavController(R.id.nav_host_fragment)
        supportActionBar?.title = Html.fromHtml("<font color='#FFFFFF'>Выбор ресторана</font>")

        val appbarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appbarConfiguration)
    }
}
