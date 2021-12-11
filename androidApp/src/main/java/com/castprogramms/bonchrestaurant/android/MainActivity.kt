package com.castprogramms.bonchrestaurant.android

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.castprogramms.bonchrestaurant.CLASSTEST
import com.castprogramms.bonchrestaurant.android.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val a : CLASSTEST by inject()
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
