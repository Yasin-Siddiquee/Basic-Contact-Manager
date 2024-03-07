package com.example.contactmanager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactmanager.databinding.ActivityMyContactsBinding

class MyContacts : AppCompatActivity() {
    lateinit var binding: ActivityMyContactsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyContactsBinding.inflate((layoutInflater))
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {

        }
    }
}