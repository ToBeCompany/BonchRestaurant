package com.castprogramms.bonchrestaurant.android.ui.tips

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentTipsBinding
import com.google.android.material.button.MaterialButton

class TipsFragment: Fragment(R.layout.fragment_tips) {
    lateinit var binding: FragmentTipsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTipsBinding.bind(view)
        binding.firstButton.setOnClickListener {
            changeOnClick(it as MaterialButton)
            binding.textTip.text = Editable.Factory.getInstance().newEditable((it as MaterialButton).text)
        }

        binding.secondButton.setOnClickListener {
            changeOnClick(it as MaterialButton)
            binding.textTip.text = Editable.Factory.getInstance().newEditable((it as MaterialButton).text)
        }

        binding.thirdButton.setOnClickListener {
            changeOnClick(it as MaterialButton)
            binding.textTip.text = Editable.Factory.getInstance().newEditable((it as MaterialButton).text)
        }

        binding.fourthButton.setOnClickListener {
            changeOnClick(it as MaterialButton)
            binding.textTip.text = Editable.Factory.getInstance().newEditable((it as MaterialButton).text)
        }

        binding.pay.setOnClickListener {
            it.findNavController().navigate(R.id.action_tipsFragment_to_callbackFragment2)
        }
    }


    private fun changeOnClick(button: MaterialButton){
        val buttons = listOf(binding.firstButton, binding.secondButton, binding.thirdButton, binding.fourthButton) - button
        button.strokeWidth = 20
        button.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
        button.strokeColor = ColorStateList.valueOf(Color.BLACK)
        button.rippleColor = ColorStateList.valueOf(Color.RED)

        buttons.forEach {
            it.strokeWidth = 0
            it.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#D9EFFF"))
        }
    }
}