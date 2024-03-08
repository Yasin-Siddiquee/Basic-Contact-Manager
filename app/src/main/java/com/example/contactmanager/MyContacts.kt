package com.example.contactmanager

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactmanager.databinding.ActivityMyContactsBinding

class MyContacts : AppCompatActivity() {
    companion object{
        const val KEY = "com.example.contactmanager.MyContacts.uniqueID"
    }
    lateinit var binding: ActivityMyContactsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyContactsBinding.inflate((layoutInflater))
        setContentView(binding.root)

        val uniqueID = intent.getStringExtra(SignIn.KEY)

        binding.floatingActionButton.setOnClickListener {

            val intent = Intent(this, AddNewContact::class.java)
            intent.putExtra(KEY, uniqueID.toString())
            startActivity(intent)

        }
    }
}