package com.castprogramms.bonchrestaurant

import com.castprogramms.bonchrestaurant.model.Food
import com.castprogramms.bonchrestaurant.utils.Resource
import com.castprogramms.bonchrestaurant.utils.Restaurant
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import org.koin.core.component.KoinComponent

class RestaurantRepository(
    private val firebaseFirestore: FirebaseFirestore
) : KoinComponent {
    companion object {
        const val restaurant_tag = "restaurants"
    }

    private val foodsDataCache : MutableMap<String, List<Food>> = mutableMapOf()
    private var lastRestName: String = ""

    fun foods(restName : String = lastRestName):List<Food> {
        lastRestName = restName
        return foodsDataCache[lastRestName] ?: listOf()
    }

    fun getAllRestaurant() = flow<Resource<List<Restaurant>>> {
        emit(Resource.Loading())
        val snapshot = firebaseFirestore.collection(restaurant_tag).get().await()
        val listRestaurants = snapshot.toObjects(Restaurant::class.java)
        for (listRestaurant in listRestaurants) {
            foodsDataCache[listRestaurant.name] = listRestaurant.foods
        }
        emit(Resource.Success(listRestaurants))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun addRestaurant(restaurant: Restaurant) {
        firebaseFirestore.collection(restaurant_tag)
            .document()
            .set(restaurant)
    }
}