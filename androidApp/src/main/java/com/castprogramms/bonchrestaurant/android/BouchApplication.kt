package com.castprogramms.bonchrestaurant.android

import androidx.multidex.MultiDexApplication
import com.castprogramms.bonchrestaurant.Platform
import com.castprogramms.bonchrestaurant.android.ui.booking.BookingViewModel
import com.castprogramms.bonchrestaurant.android.ui.order.OrderViewModel
import com.castprogramms.bonchrestaurant.android.ui.selectionrestaurant.SelectionRestaurantViewModel
import com.castprogramms.bonchrestaurant.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.logger.Level
import org.koin.dsl.module

class BouchApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Platform().initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@BouchApplication)
            modules(module {
                viewModel { OrderViewModel(get(),get()) }
                viewModel { SelectionRestaurantViewModel(get()) }
                viewModel { BookingViewModel(get()) }
            })
        }
    }
}