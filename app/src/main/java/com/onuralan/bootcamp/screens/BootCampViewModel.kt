package com.onuralan.bootcamp.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class BootCampViewModel:ViewModel(){
    var loginEmail = mutableStateOf("")
    var loginPassword = mutableStateOf("")
    var registerName = mutableStateOf("")
    var registerEmail = mutableStateOf("")
    var registerPassword = mutableStateOf("")
    private lateinit var auth:FirebaseAuth;
    var currentUser:FirebaseUser? = null
    public fun initFirebase(){
        auth = Firebase.auth
        currentUser = auth.currentUser

    }
    fun login(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                println("Login Success")
                currentUser = auth.currentUser;
            }
            else{
                println("Login Failed")
            }
        }
    }
    fun register(name:String,email: String,password: String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                println("Register Success")
                currentUser = auth.currentUser
            }
            else{
                println("Registiration Failed")
            }
        }
    }
}


