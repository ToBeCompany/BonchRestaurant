package com.castprogramms.bonchrestaurant.android.ui.infobook

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentInfoBookBinding

class InfoBookFragment: Fragment(R.layout.fragment_info_book) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentInfoBookBinding.bind(view)
        binding.viewOrder.setOnClickListener {
            it.findNavController()
        }

        binding.callWaiter.setOnClickListener {
            it.findNavController()
        }
    }
}