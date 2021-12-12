package com.castprogramms.bonchrestaurant.android.ui.booking

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.castprogramms.bonchrestaurant.android.R
import com.castprogramms.bonchrestaurant.android.databinding.FragmentBookingBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import java.util.*

class BookingFragment : Fragment(R.layout.fragment_booking) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBookingBinding.bind(view)

        binding.quantityGuestsText.text = Editable.Factory.getInstance().newEditable("1")

        binding.buttonAddQuantityGuests.setOnClickListener {
            binding.quantityGuestsText.text = Editable.Factory.getInstance()
                .newEditable((binding.quantityGuestsText.text.toString().toInt() + 1).toString())
        }

        binding.buttonMinusQuantityGuests.setOnClickListener {
            if (binding.quantityGuestsText.text.toString().toInt() > 1)
                binding.quantityGuestsText.text = Editable.Factory.getInstance()
                .newEditable((binding.quantityGuestsText.text.toString().toInt() - 1).toString())
        }

        binding.buttonGetDate.setOnClickListener {
            createDatePicker {
                val calendar = Calendar.getInstance().apply {
                    this.timeInMillis = it
                }
                binding.dateText.text = Editable.Factory.getInstance().newEditable(
                    "${calendar.get(Calendar.DAY_OF_MONTH)}/${calendar.get(Calendar.MONTH)}/${
                        calendar.get(Calendar.YEAR)
                    }"
                )
            }.show(childFragmentManager, "tag")
        }

        binding.buttonGetTime.setOnClickListener {
            createTimePicker { hour, minute ->
                binding.timeText.text =
                    Editable.Factory.getInstance().newEditable("$hour:$minute")
            }.show(childFragmentManager, "tag")
        }

        binding.buttonBook.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookingFragment_to_successBookingFragment)
        }
    }

    private fun createDatePicker(date: (millis: Long) -> Unit): MaterialDatePicker<Long> {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Выбор даты бронирования")
                .build()
        datePicker.addOnPositiveButtonClickListener {
            date(it)
        }
        return datePicker
    }

    private fun createTimePicker(time: (hour: Int, minute: Int) -> Unit): MaterialTimePicker {
        val timePicker = MaterialTimePicker.Builder()
            .setTitleText("Выбор времени бронирования")
            .build()
        timePicker.addOnPositiveButtonClickListener {
            time(timePicker.hour, timePicker.minute)
        }

        return timePicker
    }
}