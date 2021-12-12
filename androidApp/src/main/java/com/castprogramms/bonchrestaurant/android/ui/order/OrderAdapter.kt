package com.castprogramms.bonchrestaurant.android.ui.order

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.ItemMenuBinding
import com.castprogramms.bonchrestaurant.model.Food

class OrderAdapter(
    private val items : List<Food>
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_menu, parent,false)
        )
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size

    class OrderViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val item = ItemMenuBinding.bind(view)
        fun onBind(food: Food){
            item.cost.text = food.cost.toString()
            item.title.text = food.title

            Glide.with(itemView)
                .load(Uri.parse(food.image))
                .apply(RequestOptions.bitmapTransform(RoundedCorners(40)))
                .into(item.image)
        }
    }
}