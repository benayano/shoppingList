package com.example.sopinglist.uiSupporters

data class ListItemViewData(
  val  listItemViewData: List<ItemViewData> =  emptyList()
)

data class ItemViewData(
    val sirialNumber: Int?,
    val name: String,
    var amount: Int
)