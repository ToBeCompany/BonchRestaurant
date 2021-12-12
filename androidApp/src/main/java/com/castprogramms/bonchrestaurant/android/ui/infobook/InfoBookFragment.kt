package com.castprogramms.bonchrestaurant.android.ui.infobook

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentInfoBookBinding
import com.castprogramms.bonchrestaurant.android.ui.booking.BookingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class InfoBookFragment: Fragment(R.layout.fragment_info_book) {
    val viewModel: BookingViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentInfoBookBinding.bind(view)
        binding.viewOrder.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoBookFragment_to_checkOrderFragment)
        }

        binding.callWaiter.setOnClickListener {
            it.findNavController()
        }
        binding.dateTime.text = viewModel.getBook().date + ", " + viewModel.getBook().time
        binding.location.text = viewModel.getLocation()
        binding.quantityGuests.text = "Количество гостей: " + viewModel.getBook().quantity_guests
    }
}