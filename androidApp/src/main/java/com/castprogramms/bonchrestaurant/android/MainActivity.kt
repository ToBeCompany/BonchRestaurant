package com.castprogramms.bonchrestaurant.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.castprogramms.bonchrestaurant.RestaurantRepository
import com.google.android.material.textview.MaterialTextView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val a: RestaurantRepository by inject()
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = ""
        navController = findNavController(R.id.nav_host_fragment)
        val appbarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appbarConfiguration)
//        a.addFood(
//            Food(
//                100.0,
//                "asr",
//                "dassv",
//                "safwe"
//            )
//        )
    }

    fun setTitleActionBar(title: String) {
        findViewById<MaterialTextView>(R.id.title_toolbar).text = title
    }
}
