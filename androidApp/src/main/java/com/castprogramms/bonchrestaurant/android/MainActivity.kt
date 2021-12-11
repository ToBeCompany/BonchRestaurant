package com.castprogramms.bonchrestaurant.android

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.castprogramms.bonchrestaurant.CLASSTEST
import com.castprogramms.bonchrestaurant.android.databinding.ActivityMainBinding
import com.google.android.material.textview.MaterialTextView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
//    private val binding : ActivityMainBinding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val a : CLASSTEST by inject()
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = ""
        navController = findNavController(R.id.nav_host_fragment)
//        binding.titleToolbar.text = Html.fromHtml("<font color='#FFFFFF'>Выбор ресторана</font>")
        val appbarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appbarConfiguration)
    }

    fun setTitleActionBar(title: String){
        findViewById<MaterialTextView>(R.id.title_toolbar).text = title
    }
}
