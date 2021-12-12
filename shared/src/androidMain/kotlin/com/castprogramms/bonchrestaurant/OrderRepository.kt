package com.castprogramms.bonchrestaurant

import com.castprogramms.bonchrestaurant.model.Food
import org.koin.core.component.KoinComponent

class OrderRepository : KoinComponent {
    val bag : MutableList<Food> = mutableListOf()
}