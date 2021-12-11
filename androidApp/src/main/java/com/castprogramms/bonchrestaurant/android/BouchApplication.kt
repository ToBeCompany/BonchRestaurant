package com.castprogramms.bonchrestaurant.android

import android.app.Application
import com.castprogramms.bonchrestaurant.android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BouchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@BouchApplication)
            modules(appModule)
        }
    }
}