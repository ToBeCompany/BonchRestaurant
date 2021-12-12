package com.castprogramms.bonchrestaurant.android.ui.checkorder

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.ItemCheckOrderBinding
import com.castprogramms.bonchrestaurant.model.Food

class CheckOrderAdapter(
    private val items: List<Pair<Food, Int>>
) : RecyclerView.Adapter<CheckOrderAdapter.CheckOrderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckOrderViewHolder {
        return CheckOrderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_check_order, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CheckOrderViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size

    class CheckOrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCheckOrderBinding.bind(view)
        fun onBind(food : Pair<Food,Int>) {
            binding.cost.text = "$ " + food.first.cost.toString()
            binding.summaryCost.text = (food.first.cost * food.second).toString()
            Glide.with(itemView)
                .load(Uri.parse(food.first.image))
                .apply(RequestOptions.bitmapTransform(RoundedCorners(40)))
                .into(binding.image)
            binding.quantity.text = food.second.toString()
            binding.title.text = food.first.title
        }
    }

}