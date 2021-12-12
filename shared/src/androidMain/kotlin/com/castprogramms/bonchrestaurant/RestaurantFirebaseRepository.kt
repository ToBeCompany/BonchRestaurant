package com.castprogramms.bonchrestaurant

import android.util.Log
import com.castprogramms.bonchrestaurant.utils.Resource
import com.castprogramms.bonchrestaurant.utils.Restaurant
import com.google.firebase.firestore.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import org.koin.core.component.KoinComponent

class RestaurantFirebaseRepository(private val firebaseFirestore: FirebaseFirestore): KoinComponent {
    companion object{
        const val restaurant_tag = "restaurants"
    }

    fun getAllRestaurant() = flow<Resource<List<Restaurant>>>{
        emit(Resource.Loading())

        val snapshot = firebaseFirestore.collection(restaurant_tag).get().await()
        val listRestaurants = snapshot.toObjects(Restaurant::class.java)
        emit(Resource.Success(listRestaurants))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun addRestaurant(restaurant: Restaurant){
        firebaseFirestore.collection(restaurant_tag)
            .document()
            .set(restaurant)
    }

}