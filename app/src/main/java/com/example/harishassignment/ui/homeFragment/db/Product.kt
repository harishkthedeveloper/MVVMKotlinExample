package com.example.harishassignment.ui.homeFragment.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    var item_id: Int,

    @ColumnInfo(name = "item_name")
    val item_name: String,
    @ColumnInfo(name = "item_rate")
    val item_rate: Double,
    @ColumnInfo(name = "item_qty")
    val item_qty: Int,
    @ColumnInfo(name = "item_total")
    val item_total: Double
)