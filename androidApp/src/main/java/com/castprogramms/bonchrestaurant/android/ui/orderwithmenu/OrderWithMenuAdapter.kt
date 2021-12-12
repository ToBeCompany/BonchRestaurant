package com.castprogramms.bonchrestaurant.android.ui.orderwithmenu

import android.net.Uri
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.ItemMenuOrderBinding

class OrderWithMenuAdapter : RecyclerView.Adapter<OrderWithMenuAdapter.OrderWithMenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderWithMenuViewHolder {
        return OrderWithMenuViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_menu_order, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OrderWithMenuViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = 10

    inner class OrderWithMenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMenuOrderBinding.bind(view)
        fun bind() {
            binding.minusItem.setOnClickListener {
                if (binding.countItems.text.toString().toInt() > 0)
                binding.countItems.text = Editable.Factory.getInstance()
                    .newEditable((binding.countItems.text.toString().toInt() - 1).toString())
            }


            binding.addItem.setOnClickListener {
                binding.countItems.text = Editable.Factory.getInstance()
                    .newEditable((binding.countItems.text.toString().toInt() + 1).toString())
            }
        }
    }
}