package com.example.harishassignment.ui.updateFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.harishassignment.ui.homeFragment.db.ProductRepositry
import java.lang.IllegalArgumentException

class UpdateCardViewModelFactory(private val productRepositry: ProductRepositry) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UpdateCardViewModel::class.java)){
            return UpdateCardViewModel(productRepositry) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}