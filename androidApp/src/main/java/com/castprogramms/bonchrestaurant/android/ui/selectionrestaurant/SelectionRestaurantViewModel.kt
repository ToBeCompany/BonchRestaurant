package com.castprogramms.bonchrestaurant.android.ui.selectionrestaurant

import androidx.lifecycle.ViewModel
import com.castprogramms.bonchrestaurant.RestaurantFirebaseRepository

class SelectionRestaurantViewModel(private val firebaseRepository: RestaurantFirebaseRepository): ViewModel() {
    fun getAllRestaurants() = firebaseRepository.getAllRestaurant()
}