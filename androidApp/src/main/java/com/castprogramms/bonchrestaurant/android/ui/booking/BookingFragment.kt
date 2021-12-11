package com.castprogramms.bonchrestaurant.android.ui.booking

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentBookingBinding

class BookingFragment: Fragment(R.layout.fragment_booking) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBookingBinding.bind(view)
    }
}