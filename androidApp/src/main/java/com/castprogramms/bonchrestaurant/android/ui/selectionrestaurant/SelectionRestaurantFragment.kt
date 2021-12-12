package com.castprogramms.bonchrestaurant.android.ui.selectionrestaurant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import com.castprogramms.bonchrestaurant.android.MainActivity
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentSelectionRestaurantBinding
import com.castprogramms.bonchrestaurant.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectionRestaurantFragment: Fragment(R.layout.fragment_selection_restaurant) {
    val viewModel: SelectionRestaurantViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSelectionRestaurantBinding.bind(view)
        val adapter = RestaurantAdapter()
        binding.recyclerRestaurants.adapter = adapter
        lifecycle.coroutineScope.launch {
            viewModel.getAllRestaurants().collect {
                when(it){
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        if (it.data != null){
                            adapter.restaurants = it.data!!
                        }
                    }
                }
            }
        }
    }
}