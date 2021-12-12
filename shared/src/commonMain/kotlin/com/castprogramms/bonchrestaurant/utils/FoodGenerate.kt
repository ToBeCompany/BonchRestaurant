package com.castprogramms.bonchrestaurant.utils

import com.castprogramms.bonchrestaurant.model.Food

val foodNames = listOf(
    "Вкуснотища",
    "Батя у плиты",
    "All in по турецки",
    "Осенний завтрак",
    "Аппетитное нечто",
    "От шеф повара",
    "Итальянский каравай",
    "Ничто кроме сыра",
    "Пирожки с яйцом",
)
val category = listOf(
    "Топ месяца",
    "Сезонное",
    "Ужин на двоих",
    "Рекомендуют",
)
val images = listOf(
    "https://firebasestorage.googleapis.com/v0/b/bonchrestaurant.appspot.com/o/foods%2Ffood1.jpeg?alt=media&token=dd00520b-5e4c-49da-8083-327144cc829e",
    "https://firebasestorage.googleapis.com/v0/b/bonchrestaurant.appspot.com/o/foods%2Ffood2.jpeg?alt=media&token=8c34fd89-d5ac-4d1c-9a89-7397985864e2",
    "https://firebasestorage.googleapis.com/v0/b/bonchrestaurant.appspot.com/o/foods%2Ffood3.jpeg?alt=media&token=eee4f5ff-a709-47f5-8555-269fe3fdb887",
    "https://firebasestorage.googleapis.com/v0/b/bonchrestaurant.appspot.com/o/foods%2Ffood4.jpeg?alt=media&token=327b946b-a326-4eba-95a8-9b337bfc20e5",
    "https://firebasestorage.googleapis.com/v0/b/bonchrestaurant.appspot.com/o/foods%2Ffood5.jpeg?alt=media&token=350cb551-bd80-48a2-bfb4-e8f3fe2fb218",
    "https://firebasestorage.googleapis.com/v0/b/bonchrestaurant.appspot.com/o/foods%2Ffood6.jpeg?alt=media&token=e7e22277-1833-4619-a1bd-f3cf47595ca6",
    "https://firebasestorage.googleapis.com/v0/b/bonchrestaurant.appspot.com/o/foods%2Ffood7.jpeg?alt=media&token=db3dc386-8a66-4eb3-848f-2aecbb5b944e",
    "https://firebasestorage.googleapis.com/v0/b/bonchrestaurant.appspot.com/o/foods%2Ffood8.jpeg?alt=media&token=b5b04166-c7ce-4cc6-a746-3899ddaf8f55",
    "https://firebasestorage.googleapis.com/v0/b/bonchrestaurant.appspot.com/o/foods%2Ffood9.jpeg?alt=media&token=96e46dfc-1826-43ba-a1ee-98c85f246b18"
)
fun generateFood()= Food(
    (2..25).random().toDouble(),
    foodNames.random(),
    images.random(),
    category.random()
)
