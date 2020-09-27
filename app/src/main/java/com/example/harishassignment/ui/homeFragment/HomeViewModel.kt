package com.example.harishassignment.ui.homeFragment

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harishassignment.ui.homeFragment.db.Product
import com.example.harishassignment.ui.homeFragment.db.ProductRepositry
import kotlinx.coroutines.launch

class HomeViewModel(private val productRepositry: ProductRepositry) : ViewModel(), Observable {

    fun getProDuctList(): LiveData<List<Product>> {
        return productRepositry.getAllProductsLiveData();
    }

    init { }

    fun deleteProduct(product: Product) = viewModelScope.launch {
        productRepositry.delete(product)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}