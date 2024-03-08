package com.example.contactmanager

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactmanager.databinding.ActivityAddNewContactBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddNewContact : AppCompatActivity() {

    lateinit var database: DatabaseReference
    lateinit var binding: ActivityAddNewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uniqueID = intent.getStringExtra(MyContacts.KEY)

        binding.btnSave.setOnClickListener {
            val name = binding.cName.text.toString()
            val mail = binding.cMail.text.toString()
            val phone = binding.cNumber.text.toString()

            val contacts = Contacts(name, mail, phone)
            database = FirebaseDatabase.getInstance().getReference("Users/$uniqueID/Contacts")
            database.child(name).setValue(contacts).addOnSuccessListener {
                binding.cName.text?.clear()
                binding.cMail.text?.clear()
                binding.cNumber.text?.clear()

                Toast.makeText(this, "New Contact Saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }
