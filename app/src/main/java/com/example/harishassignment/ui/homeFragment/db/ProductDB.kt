package com.example.harishassignment.ui.homeFragment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Product::class],version = 4)
abstract class ProductDB: RoomDatabase() {
    abstract val productDAO: ProductDAO
    // we need to create a single instance of db to use in whole project
    // so we have to create single ton class
    // this a boilerplate code
    companion object{
        @Volatile
        private var INSTANCE: ProductDB?=null
        fun  getInstance(context: Context):ProductDB{
            synchronized(this){
                var instance:ProductDB?= INSTANCE
                if(instance == null ){
                    instance=Room.databaseBuilder(
                        context.applicationContext,ProductDB::class.java,
                        "product_table"
                    ).build()
                }
                return instance
            }
        }
    }
}