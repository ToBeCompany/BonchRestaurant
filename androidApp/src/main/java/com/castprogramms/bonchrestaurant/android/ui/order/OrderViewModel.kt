package com.castprogramms.bonchrestaurant.android.ui.order

import androidx.lifecycle.ViewModel
import com.castprogramms.bonchrestaurant.model.Food
import kotlinx.coroutines.flow.flow

class OrderViewModel : ViewModel() {

    val flow = flow<List<Food>> {
        List<Food>(10){
            Food(10.0,"1231", "21e21", "q2ss")
        }
    }
}