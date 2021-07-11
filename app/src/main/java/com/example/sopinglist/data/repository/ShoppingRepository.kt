package com.example.sopinglist.data.repository

import com.example.sopinglist.data.db.ShoppingDb
import com.example.sopinglist.data.db.entity.ShoppingItem

class ShoppingRepository(private val shoppingDb: ShoppingDb) {

    suspend fun upsert(shoppingItem: ShoppingItem) =
        shoppingDb.getShoppingDao().upsertItem(shoppingItem)

    suspend fun delete(shoppingItem: ShoppingItem) =
        shoppingDb.getShoppingDao().deleteItem(shoppingItem)

     fun getAllShoppingItems() = shoppingDb.getShoppingDao().getAllShoppingItems()
}