package com.castprogramms.bonchrestaurant

import com.google.firebase.firestore.FirebaseFirestore
import org.koin.core.component.KoinComponent

class FoodRepository(
    private val firebase : FirebaseFirestore
) : KoinComponent {
    companion object {
        private val FOOD_COLLECTION = "foods"
    }

    var currentRestaurantName = ""

}