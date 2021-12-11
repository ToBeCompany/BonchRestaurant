package com.castprogramms.bonchrestaurant.android

import androidx.multidex.MultiDexApplication
import com.castprogramms.bonchrestaurant.android.ui.order.OrderViewModel
import com.castprogramms.bonchrestaurant.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.logger.Level
import org.koin.dsl.module

class BouchApplication : MultiDexApplication() {
    private val androidModule = module {
        viewModel { OrderViewModel() }
    }
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@BouchApplication)
            modules(androidModule)
        }
    }
}