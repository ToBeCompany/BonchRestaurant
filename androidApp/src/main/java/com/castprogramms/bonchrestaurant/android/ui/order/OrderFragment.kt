package com.castprogramms.bonchrestaurant.android.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.castprogramms.bonchrestaurant.android.databinding.OrderFragmentBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderFragment : Fragment() {
    private lateinit var binding: OrderFragmentBinding
    private val viewModel : OrderViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OrderFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            viewModel.flow.collect {
                binding.foodList.adapter = OrderAdapter(it)
            }
        }
    }

}