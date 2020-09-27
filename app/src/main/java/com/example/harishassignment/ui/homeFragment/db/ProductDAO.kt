package com.example.harishassignment.ui.homeFragment.db

import androidx.lifecycle.LiveData
import androidx.room.*
import javax.security.auth.Subject

@Dao
interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product): Long

    @Update
    suspend fun updateProduct(product: Product)

    // SUSPEND KEY ADDED TO EXECUTE IN BACKGROUD USING COROTINES
    @Delete
    suspend fun deleteProduct(product: Product)

    // WE DONT NEED TO EXECUTE THIS IN BACKGROUND THREAD SO NO NEED TO ADD SUSPEND KEY
    @Query("SELECT * FROM PRODUCT_TABLE")
    fun getAllProducts():LiveData<List<Product>>
}