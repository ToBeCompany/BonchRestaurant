package com.castprogramms.bonchrestaurant.android

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.castprogramms.bonchrestaurant.android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class BoucnApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@BoucnApplication)
            modules(appModule)
        }
    }
}