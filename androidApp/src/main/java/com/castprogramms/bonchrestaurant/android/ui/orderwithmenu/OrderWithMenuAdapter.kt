package com.castprogramms.bonchrestaurant.android.ui.orderwithmenu

import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.ItemMenuOrderBinding
import com.castprogramms.bonchrestaurant.android.ui.order.OrderAdapter
import com.castprogramms.bonchrestaurant.android.ui.order.OrderViewModel
import com.castprogramms.bonchrestaurant.model.Food
import de.hdodenhof.circleimageview.CircleImageView
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderWithMenuAdapter(
    items: List<Food>
) : OrderAdapter(
    items
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderWithMenuViewHolder {
        return OrderWithMenuViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_menu_order, parent, false)
        )
    }

    inner class OrderWithMenuViewHolder(view: View) : OrderViewHolder(view) {
        private val binding = ItemMenuOrderBinding.bind(view)
        override val itemCost: TextView = binding.cost
        override val itemTitle: TextView = binding.title
        override val itemImage: CircleImageView = binding.image

        override fun onBind(food: Food) {
            super.onBind(food)
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