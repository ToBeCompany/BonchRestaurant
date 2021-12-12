package com.castprogramms.bonchrestaurant.android.ui.orderwithmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentOrderWithMenuBinding
import com.castprogramms.bonchrestaurant.android.ui.order.OrderAdapter
import com.castprogramms.bonchrestaurant.android.ui.order.OrderViewModel
import com.castprogramms.bonchrestaurant.android.ui.tools.BounceEdgeEffectFactory
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderWithMenuFragment: Fragment(R.layout.fragment_order_with_menu) {

    private val viewModel : OrderViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadCacheFoods()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        val binding = FragmentOrderWithMenuBinding.bind(view)

        binding.recyclerOrderMenu.edgeEffectFactory = BounceEdgeEffectFactory()
        binding.recyclerOrderMenu.layoutManager = GridLayoutManager(requireContext(), 2)
        lifecycleScope.launchWhenStarted {
            viewModel.foodStateFlow.collectLatest {
                binding.recyclerOrderMenu.adapter = OrderWithMenuAdapter(it, {
                    viewModel.add(it.copy())
                },{
                    viewModel.remove(it.copy())
                })
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.order_menu, menu)
        menu.findItem(R.id.order).setOnMenuItemClickListener {
            findNavController().navigate(
                OrderWithMenuFragmentDirections.actionOrderWithMenuFragmentToCheckOrderFragment()
            )
            return@setOnMenuItemClickListener true
        }

        super.onCreateOptionsMenu(menu, inflater)
    }
}