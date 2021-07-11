package com.example.sopinglist.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="shopping_items")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "item_name")
    val name:String,
    @ColumnInfo(name = "item_amount" )
    var amount:Int
)