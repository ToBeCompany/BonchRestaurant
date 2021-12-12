package com.castprogramms.bonchrestaurant.android.ui.selectionrestaurant

import androidx.lifecycle.ViewModel
import com.castprogramms.bonchrestaurant.RestaurantRepository

class SelectionRestaurantViewModel(private val repository: RestaurantRepository): ViewModel() {
    fun getAllRestaurants() = repository.getAllRestaurant()
}