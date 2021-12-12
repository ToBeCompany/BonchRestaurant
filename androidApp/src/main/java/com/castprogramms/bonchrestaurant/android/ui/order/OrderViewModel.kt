package com.castprogramms.bonchrestaurant.android.ui.order

import androidx.lifecycle.ViewModel
import com.castprogramms.bonchrestaurant.RestaurantRepository
import com.castprogramms.bonchrestaurant.model.Food
import kotlinx.coroutines.flow.MutableStateFlow

class OrderViewModel(
    private val restaurantRepository: RestaurantRepository
) : ViewModel() {

    val foodStateFlow = MutableStateFlow<List<Food>>(listOf())

    fun setupFoods(id : String){
        foodStateFlow.value = restaurantRepository.foodsDataCache[id] ?: listOf()
    }
}