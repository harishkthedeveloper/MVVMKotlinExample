package com.example.harishassignment.ui.homeFragment.db

import androidx.lifecycle.LiveData

class ProductRepositry(private val dao: ProductDAO) {
   // val producs = dao.getAllProducts()

    fun getAllProductsLiveData()=dao.getAllProducts()


    suspend fun insert(product: Product){
        dao.insertProduct(product)
    }
    suspend fun update(product: Product){
        dao.updateProduct(product)
    }
    suspend fun delete(product: Product){
        dao.deleteProduct(product)
    }
}