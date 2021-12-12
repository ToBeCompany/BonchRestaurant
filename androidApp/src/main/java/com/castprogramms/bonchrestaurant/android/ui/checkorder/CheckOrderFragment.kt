package com.castprogramms.bonchrestaurant.android.ui.checkorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentCheckOrderBinding
import com.castprogramms.bonchrestaurant.android.ui.order.OrderViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class CheckOrderFragment : Fragment(R.layout.fragment_check_order) {
    val viewModel : OrderViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadBag()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCheckOrderBinding.bind(view)

        binding.foodList.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launchWhenStarted {
            viewModel.bagState.collectLatest{
                binding.foodList.adapter = CheckOrderAdapter(it)
            }
        }

        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.action_checkOrderFragment_to_orderWithMenuFragment)
        }
    }
}