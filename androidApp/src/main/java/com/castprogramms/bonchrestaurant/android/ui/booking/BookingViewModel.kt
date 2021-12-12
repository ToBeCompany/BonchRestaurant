package com.castprogramms.bonchrestaurant.android.ui.booking

import androidx.lifecycle.ViewModel
import com.castprogramms.bonchrestaurant.BookingRepository
import com.castprogramms.bonchrestaurant.utils.Book

class BookingViewModel(private val bookingRepository: BookingRepository): ViewModel() {
    fun setBook(book: Book){
        bookingRepository.book = book
    }
    fun setLocation(location: String){
        bookingRepository.location = location
    }

    fun getLocation() = bookingRepository.location

    fun getBook() = bookingRepository.book
}