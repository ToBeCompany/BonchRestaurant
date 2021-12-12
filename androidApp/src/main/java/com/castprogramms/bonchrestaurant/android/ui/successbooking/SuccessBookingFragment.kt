package com.castprogramms.bonchrestaurant.android.ui.successbooking

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentSuccessBookingBinding

class SuccessBookingFragment: Fragment(R.layout.fragment_success_booking) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSuccessBookingBinding.bind(view)
        binding.buttonCreateOrder.setOnClickListener {
            it.findNavController().navigate(R.id.action_successBookingFragment_to_orderWithMenuFragment)
        }

        binding.buttonCancelOrder.setOnClickListener {
            it.findNavController().navigate(R.id.action_successBookingFragment_to_infoBookFragment)
        }
    }
}