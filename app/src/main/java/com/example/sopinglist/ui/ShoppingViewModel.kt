package com.example.sopinglist.ui

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.sopinglist.data.db.entity.ShoppingItem
import com.example.sopinglist.data.repository.ShoppingRepository
import com.example.sopinglist.uiSupporters.ItemViewData
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val shoppingRepository: ShoppingRepository
) : ViewModel() {

    private val listItemLiveData =shoppingRepository
        .getAllShoppingItems()
        .map {   convertListDataToListItemViewData(it)  }

    fun upsert(itemViewData: ItemViewData) =
        viewModelScope.launch {
            shoppingRepository.upsert(
                convertDataToShoppingItem(itemViewData)
            )
        }

    fun delete(itemViewData: ItemViewData) =
        viewModelScope.launch {
            shoppingRepository.delete(
                convertDataToShoppingItem(itemViewData)
            )
        }

    fun plusAmount(itemViewData: ItemViewData){
        itemViewData.copy(amount = itemViewData.amount+1)
    }
    fun minusAmount(itemViewData: ItemViewData){
        itemViewData.copy(amount = itemViewData.amount-1)
    }

    fun getList()=listItemLiveData
    //--------------------------------converters-------------------------------------------------//
    private fun convertDataToShoppingItem(itemViewData: ItemViewData) =
        ShoppingItem(itemViewData.sirialNumber, itemViewData.name, itemViewData.amount)


    private fun convertListDataToListItemViewData(listShoppingItem:List<ShoppingItem>):List<ItemViewData> =
        listShoppingItem.map {
            ItemViewData(
                it.id,
                it.name,
                it.amount
            )
        }


}

