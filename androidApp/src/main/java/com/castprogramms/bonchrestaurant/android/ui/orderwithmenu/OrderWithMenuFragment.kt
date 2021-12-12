package com.castprogramms.bonchrestaurant.android.ui.orderwithmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentOrderWithMenuBinding
import com.castprogramms.bonchrestaurant.android.ui.tools.BounceEdgeEffectFactory

class OrderWithMenuFragment: Fragment(R.layout.fragment_order_with_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        val binding = FragmentOrderWithMenuBinding.bind(view)
        binding.recyclerOrderMenu.adapter = OrderWithMenuAdapter()
        binding.recyclerOrderMenu.edgeEffectFactory = BounceEdgeEffectFactory()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.order_menu, menu)
        menu.findItem(R.id.order).setOnMenuItemClickListener {
            return@setOnMenuItemClickListener true
        }

        super.onCreateOptionsMenu(menu, inflater)
    }
}