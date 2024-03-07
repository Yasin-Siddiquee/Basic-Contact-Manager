package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactmanager.databinding.ActivitySignUpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

    lateinit var database: DatabaseReference
    lateinit var  binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            val name = binding.etName.text.toString()
            val mail = binding.etMail.text.toString()
            val password = binding.etPassword.text.toString()
            val uniqueId = binding.etUsername.text.toString()

            val user = User(name, mail, password, uniqueId)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueId).setValue(user).addOnSuccessListener {
                binding.etName.text?.clear()
                binding.etMail.text?.clear()
                binding.etPassword.text?.clear()
                binding.etUsername.text?.clear()

                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }
        }

        binding.TvSignIn.setOnClickListener {
            val openSignIn = Intent(this, SignIn::class.java)
            startActivity(openSignIn)
        }


    }
}