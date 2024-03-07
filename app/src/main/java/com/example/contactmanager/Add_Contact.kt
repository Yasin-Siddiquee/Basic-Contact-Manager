package com.example.contactmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactmanager.databinding.ActivityAddContactBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Add_Contact : AppCompatActivity() {

    lateinit var database: DatabaseReference
    lateinit var binding: ActivityAddContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uniqueID = intent.getStringExtra(SignIn.KEY)

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