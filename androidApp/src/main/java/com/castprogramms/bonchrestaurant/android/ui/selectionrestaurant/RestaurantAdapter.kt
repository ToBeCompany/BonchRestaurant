package com.castprogramms.bonchrestaurant.android.ui.selectionrestaurant

import android.net.Uri
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.ItemRestaurantBinding
import com.castprogramms.bonchrestaurant.utils.Restaurant

class RestaurantAdapter(
    private val listener: (restName: String) -> Unit,
    val setLocation: (String) -> Unit
): RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>(){
    var restaurants = listOf<Restaurant>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false))
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(restaurants[position])
    }

    override fun getItemCount() = restaurants.size

    inner class RestaurantViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemRestaurantBinding.bind(view)
        fun bind(restaurant: Restaurant) {
            Glide.with(itemView)
                .load(Uri.parse(restaurant.img))
                .apply(RequestOptions.bitmapTransform(RoundedCorners(40)))
                .into(binding.imageForRestaurant)
            binding.titleForRestaurant.text = restaurant.name
            binding.textGeoPosition.text = restaurant.address.toString()

            binding.buttonForRestaurant.setOnClickListener {
                listener(restaurant.name)
                setLocation(restaurant.address.toString())
            }
        }
    }
}