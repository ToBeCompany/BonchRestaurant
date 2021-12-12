package com.castprogramms.bonchrestaurant.android.ui.infobook

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import androidx.core.animation.doOnEnd
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentInfoBookBinding
import com.castprogramms.bonchrestaurant.android.ui.booking.BookingViewModel
import com.google.android.material.animation.AnimationUtils
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
            it.animate()
                .rotationY(360f)
                .setDuration(3000)
                .setUpdateListener {
                    it.doOnEnd {
                        binding.callWaiter.text = "Официант в пути!"
                    }
                }
                .start()
        }
        binding.dateTime.text = viewModel.getBook().date + ", " + viewModel.getBook().time
        binding.location.text = viewModel.getLocation()
        binding.quantityGuests.text = "Количество гостей: " + viewModel.getBook().quantity_guests

        binding.complete.setOnClickListener {
            findNavController().navigate(R.id.action_infoBookFragment_to_tipsFragment)
        }

    }
}