package com.castprogramms.bonchrestaurant.android.di

import com.castprogramms.bonchrestaurant.android.CLASSTEST
import org.koin.dsl.module


val appModule = module {
    // single instance of HelloRepository
    single<CLASSTEST> { CLASSTEST() }

    // Simple Presenter Factory
    //factory { MySimplePresenter(get()) }
}