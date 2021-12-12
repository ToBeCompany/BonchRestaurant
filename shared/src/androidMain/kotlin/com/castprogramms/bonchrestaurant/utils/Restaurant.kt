package com.castprogramms.bonchrestaurant.utils

import com.castprogramms.bonchrestaurant.model.Food

class Restaurant(
    val name: String = "",
    val img: String = "",
    val address: Address = Address(),
    val foods : List<Food> = listOf()
)