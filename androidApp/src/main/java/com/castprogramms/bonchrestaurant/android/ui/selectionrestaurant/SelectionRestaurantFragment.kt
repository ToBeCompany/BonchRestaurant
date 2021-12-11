package com.castprogramms.bonchrestaurant.android.ui.selectionrestaurant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.castprogramms.bonchrestaurant.android.MainActivity
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentSelectionRestaurantBinding

class SelectionRestaurantFragment: Fragment(R.layout.fragment_selection_restaurant) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSelectionRestaurantBinding.bind(view)
//        (requireActivity() as MainActivity).setTitleActionBar("Выбор ресторана")
    }
}