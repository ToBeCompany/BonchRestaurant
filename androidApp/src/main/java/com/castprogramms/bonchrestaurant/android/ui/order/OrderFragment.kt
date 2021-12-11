package com.castprogramms.bonchrestaurant.android.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.OrderFragmentBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderFragment : Fragment(R.layout.order_fragment) {
    private lateinit var binding: OrderFragmentBinding
    private val viewModel : OrderViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = OrderFragmentBinding.bind(view)
        lifecycleScope.launchWhenStarted {
            viewModel.flow.collect {
                binding.foodList.adapter = OrderAdapter(it)
            }
        }

        binding.tableBook.setOnClickListener {
            it.findNavController().navigate(R.id.action_orderFragment_to_bookingFragment)
        }
    }

}