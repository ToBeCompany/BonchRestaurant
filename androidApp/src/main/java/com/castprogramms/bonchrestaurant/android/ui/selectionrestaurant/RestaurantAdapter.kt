package com.castprogramms.bonchrestaurant.android.ui.selectionrestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.ItemRestaurantBinding

class RestaurantAdapter: RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false))
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = 10

    inner class RestaurantViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemRestaurantBinding.bind(view)
        fun bind(){
            binding.root.setOnClickListener {
                it.findNavController()
                    .navigate(R.id.action_selectionRestaurantFragment_to_orderFragment)
            }
        }
    }
}