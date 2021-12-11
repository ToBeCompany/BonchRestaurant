package com.castprogramms.bonchrestaurant.android

import androidx.multidex.MultiDexApplication
import com.castprogramms.bonchrestaurant.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class BouchApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@BouchApplication)
        }
    }
}