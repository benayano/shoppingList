package com.example.sopinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sopinglist.data.db.entity.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDb : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDb? = null
        private val LOCK= Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createShoppingDb(context).also { instance = it }
        }

        private fun createShoppingDb(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDb::class.java,
                 "ShoppingDb.db"
            ).build()
    }
}