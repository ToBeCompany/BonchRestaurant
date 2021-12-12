package com.castprogramms.bonchrestaurant.utils

class Address(
    val city: String = "",
    val street: String = "",
    val number_home: String = ""
){
    override fun toString(): String {
        return "$city, $street, $number_home"
    }
}