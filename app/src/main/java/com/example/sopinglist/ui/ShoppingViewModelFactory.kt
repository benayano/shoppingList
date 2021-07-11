package com.example.sopinglist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sopinglist.data.repository.ShoppingRepository

class ShoppingViewModelFactory(private val repository: ShoppingRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }

}