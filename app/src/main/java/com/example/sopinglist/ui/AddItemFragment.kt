package com.example.sopinglist.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.sopinglist.R
import com.example.sopinglist.data.db.ShoppingDb
import com.example.sopinglist.data.repository.ShoppingRepository


class AddItemFragment : DialogFragment(R.layout.fragment_add_item) {

    private val viewModel: ShoppingViewModel by viewModels {
        val shoppingDb = ShoppingDb.invoke(requireContext())
        ShoppingViewModelFactory(ShoppingRepository(shoppingDb))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editName: EditText = view.findViewById(R.id.editText)
        val editAmount: EditText = view.findViewById(R.id.editTextNumber)
        val cancelItem: ImageView = view.findViewById(R.id.ivCancel)
        val btnOk: Button = view.findViewById(R.id.btnOk)






    }
}