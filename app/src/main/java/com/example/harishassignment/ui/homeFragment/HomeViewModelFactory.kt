package com.example.harishassignment.ui.homeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.harishassignment.ui.homeFragment.db.ProductRepositry
import com.example.harishassignment.ui.updateFragment.UpdateCardViewModel
import java.lang.IllegalArgumentException

class HomeViewModelFactory (private val productRepositry: ProductRepositry) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(productRepositry) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}