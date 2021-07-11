package com.example.sopinglist.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sopinglist.R
import com.example.sopinglist.data.db.ShoppingDb
import com.example.sopinglist.data.repository.ShoppingRepository
import com.example.sopinglist.uiSupporters.AdapterShoppingItem
import com.example.sopinglist.uiSupporters.ItemViewData
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.item_shopping.*

class ShoppingListFragment : Fragment(R.layout.fragment_shopping_list) {
    private val viewModel: ShoppingViewModel by viewModels {
        val shoppingDb = ShoppingDb.invoke(requireContext())
        ShoppingViewModelFactory(ShoppingRepository(shoppingDb))
    }
    private val recyclerItem: RecyclerView by lazy { requireView().findViewById(R.id.rvListShopp) }
    private val adapterShoppingItem: AdapterShoppingItem by lazy {
        AdapterShoppingItem(
            delete = this::deleteItem,
            plusAmount = this::plusAmount,
            minusAmount = this::minusAmount
        )
    }

    private fun minusAmount(itemViewData: ItemViewData) = viewModel.minusAmount(itemViewData)

    private fun deleteItem(itemViewData: ItemViewData) {
        viewModel.delete(itemViewData)
    }

    private fun plusAmount(itemViewData: ItemViewData) {
        Toast.makeText(requireContext(),"dddddddddddd", Toast.LENGTH_LONG).show()
        viewModel.upsert(itemViewData.copy( amount = 8 ))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addItem: FloatingActionButton = view.findViewById(R.id.addItem)

        addItem.setOnClickListener {
            viewModel.upsert(ItemViewData(null,name = "apple", amount = 6))
        }

        recyclerItem.adapter = adapterShoppingItem
        recyclerItem.layoutManager = LinearLayoutManager(requireContext())


        viewModel.getList().observe(viewLifecycleOwner, {
            adapterShoppingItem.submitList(it)
        })

    }


}