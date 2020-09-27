package com.example.harishassignment.ui.updateFragment

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.example.harishassignment.R
import com.example.harishassignment.ui.homeFragment.db.Product
import com.example.harishassignment.ui.homeFragment.db.ProductRepositry
import kotlinx.coroutines.launch

class UpdateCardViewModel(private val productRepositry: ProductRepositry) : ViewModel(),Observable {

    //val products = productRepositry.producs

    @Bindable
    var inputItemName = MutableLiveData<String>()
    @Bindable
    var inputItemQty  = MutableLiveData<String>()
    @Bindable
    var inputItemPrice = MutableLiveData<String>()
    @Bindable
    val saveOrUpdateBtnText = MutableLiveData<String>()
    @Bindable
    val addorUpdateToolBarText = MutableLiveData<String>()
    init {
        saveOrUpdateBtnText.value = "Add Product";
        addorUpdateToolBarText.value = "Add Product"
    }


     fun saveOrUpdate(){
         val itemName = inputItemName.value!!
         val itemQty = inputItemQty.value!!.toInt()
         val itemPrice = inputItemPrice.value!!.toDouble()

         insertProduct(Product(0,itemName,itemPrice,itemQty,(itemPrice*itemQty)))
         // clear value after insert
         inputItemName.value = null
         inputItemQty.value = null
         inputItemPrice.value = null

     }
    fun insertProduct(product: Product)= viewModelScope.launch {
            productRepositry.insert(product)
        }
    fun updateProduct(product: Product) = viewModelScope.launch {
        productRepositry.update(product)
    }
    fun deleteProduct(product: Product) = viewModelScope.launch {
        productRepositry.delete(product)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}