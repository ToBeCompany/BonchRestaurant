package com.castprogramms.bonchrestaurant.android.ui.order

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.OrderFragmentBinding
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderFragment : Fragment(R.layout.order_fragment) {
    private lateinit var binding: OrderFragmentBinding
    private val viewModel : OrderViewModel by viewModel()
    private val args : OrderFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadFoods(
            args.restName
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = OrderFragmentBinding.bind(view)
        binding.foodList.layoutManager = GridLayoutManager(requireContext(), 2)

        lifecycleScope.launchWhenStarted {
            viewModel.foodStateFlow.collectLatest {
                binding.foodList.adapter = OrderAdapter(it)
            }
        }

        binding.tableBook.setOnClickListener {
            it.findNavController().navigate(R.id.action_orderFragment_to_bookingFragment)
        }
    }
}