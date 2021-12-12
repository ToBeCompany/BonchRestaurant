package com.castprogramms.bonchrestaurant

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

actual class Platform actual constructor() {
    fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
        appDeclaration()
        modules(commonModule)
    }

    val commonModule = module {
        single { FirebaseFirestore.getInstance().apply {
            firestoreSettings = FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build()
        } }
        single { RestaurantRepository(get()) }
        single { FoodRepository(get()) }
    }
}