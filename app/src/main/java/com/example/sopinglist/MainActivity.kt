package com.example.sopinglist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.sopinglist.ui.ShoppingListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.commit {
            replace(R.id.hostFragment,ShoppingListFragment())
        }

    }
}