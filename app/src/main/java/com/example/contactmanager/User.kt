package com.example.contactmanager

data class User (val name: String, val mail: String, val password: String, val uniqueId: String){
}

data class Contacts(val name: String, val mail: String, val phoneNumber: String){

}