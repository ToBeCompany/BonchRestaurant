package com.castprogramms.bonchrestaurant.android.di

import org.koin.dsl.module

val appModule = module {
    // single instance of HelloRepository
    //single<> { HelloRepositoryImpl() }

    // Simple Presenter Factory
    //factory { MySimplePresenter(get()) }
}