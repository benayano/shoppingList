package com.example.sopinglist.uiSupporters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sopinglist.R

class AdapterShoppingItem(
    var delete: (itemViewData: ItemViewData) -> Unit = {},
    var plusAmount: (itemViewData: ItemViewData) -> Unit = {},
    var minusAmount: (itemViewData: ItemViewData) -> Unit = {}

) :
    ListAdapter<ItemViewData, AdapterShoppingItem.ViewHolderr>(ItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderr {
        val shoppingItemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shopping, parent, false)

        return ViewHolderr(shoppingItemView)
    }


    override fun onBindViewHolder(holderr: ViewHolderr, position: Int) {
        val currentItem = getItem(position)
        holderr.bind(currentItem)
    }


    inner class ViewHolderr(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)

        private val ivDelete: ImageView = itemView.findViewById(R.id.ivDelete)
        private val ivPlus: ImageView = itemView.findViewById(R.id.ivPlus)
        private val ivMinus: ImageView = itemView.findViewById(R.id.ivMinus)


        fun bind(itemViewData: ItemViewData) {
            tvName.text = itemViewData.name
            tvAmount.text = itemViewData.amount.toString()

            ivDelete.setOnClickListener{  delete(itemViewData)}
            ivPlus.setOnClickListener { plusAmount(itemViewData) }
            ivMinus.setOnClickListener { minusAmount(itemViewData) }
        }
    }

}


class ItemDiffUtil : DiffUtil.ItemCallback<ItemViewData>() {
    override fun areItemsTheSame(
        oldItemViewData: ItemViewData,
        newItemViewData: ItemViewData
    ): Boolean {
        return oldItemViewData === newItemViewData
    }

    override fun areContentsTheSame(
        oldItemViewData: ItemViewData,
        newItemViewData: ItemViewData
    ): Boolean {
        return oldItemViewData == newItemViewData
    }
}

