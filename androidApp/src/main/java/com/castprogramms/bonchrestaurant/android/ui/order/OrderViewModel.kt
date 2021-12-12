package com.castprogramms.bonchrestaurant.android.ui.order

import android.util.Log
import androidx.lifecycle.ViewModel
import com.castprogramms.bonchrestaurant.OrderRepository
import com.castprogramms.bonchrestaurant.RestaurantRepository
import com.castprogramms.bonchrestaurant.model.Food
import kotlinx.coroutines.flow.MutableStateFlow

class OrderViewModel(
    private val restaurantRepository: RestaurantRepository,
    private val orderRepository : OrderRepository
) : ViewModel() {

    val foodStateFlow = MutableStateFlow<List<Food>>(listOf())
    val bagState: MutableStateFlow<List<Pair<Food, Int>>> = MutableStateFlow(listOf())

    fun loadFoods(id : String){
        foodStateFlow.value = restaurantRepository.foods(id)
    }
    fun loadCacheFoods(){
        foodStateFlow.value = restaurantRepository.foods()
    }

    fun loadBag(){
        bagState.value = orderRepository.bag.toSet().map { item ->  item to orderRepository.bag.count { it==item } }
        Log.d("q3223", orderRepository.bag.toString())
        Log.d("q3223wecw", bagState.value.toString())
    }

    fun add(food: Food){
        orderRepository.bag.add(food)
        Log.d("q3223", orderRepository.bag.toString())

    }
    fun remove(food: Food){
        orderRepository.bag.remove(food)
    }
    fun clearBag(){
        orderRepository.bag.clear()
    }
}