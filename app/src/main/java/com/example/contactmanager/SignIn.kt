package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactmanager.databinding.ActivitySignInBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignIn : AppCompatActivity() {

    lateinit var database: DatabaseReference
    companion object{
        const val KEY = "com.example.contactmanager.SignIn.uniqueID"
    }
    lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            val uniqueId = binding.userName.text.toString()
            if(uniqueId.isNotEmpty()){
                readData(uniqueId)
            }else{
                Toast.makeText(this,"Please enter your Username", Toast.LENGTH_SHORT).show()
            }
        }

        binding.viewSignUp.setOnClickListener {
            val openSignUp = Intent(this, SignUp::class.java)
            startActivity(openSignUp)
        }

    }

    private fun readData(uniqueId: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uniqueId).get().addOnSuccessListener {
            if (it.exists()){
                val intent = Intent(this,MyContacts::class.java)
                intent.putExtra(KEY,binding.userName.text.toString())
                startActivity(intent)





            }else{
                Toast.makeText(this, "Username does not exist, please sign up", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this, "Failed, Error in DB", Toast.LENGTH_SHORT)
        }

    }
}