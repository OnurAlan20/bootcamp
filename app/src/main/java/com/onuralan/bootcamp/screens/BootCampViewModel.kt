package com.onuralan.bootcamp.screens

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.type.DateTime
import com.onuralan.bootcamp.models.Message
import com.onuralan.bootcamp.models.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.UUID

class BootCampViewModel:ViewModel(){
    var loginEmail = mutableStateOf("")
    var loginPassword = mutableStateOf("")
    var registerName = mutableStateOf("")
    var registerEmail = mutableStateOf("")
    var registerPassword = mutableStateOf("")
    private lateinit var auth:FirebaseAuth;
    var currentUser:FirebaseUser? = null
    lateinit var db:FirebaseFirestore
    lateinit var user:User
    public fun initFirebase(){
        auth = Firebase.auth
        currentUser = auth.currentUser
        db = Firebase.firestore
    }
    fun login(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                currentUser = auth.currentUser;
                db.collection("users").get().addOnCompleteListener {
                    result -> for (document in result.result.documents){
                        if (document.data?.get("uid") == currentUser?.uid){
                            user = User(document.data?.get("name") as String?,
                            document.data?.get("email") as String?,
                                document.data?.get("password") as String?,
                                document.data?.get("uid") as String?
                            )
                            println("Login Success")
                            println("User:" + user.uid)
                        }
                    }
                }
            }
            else{
                println("Login Failed")
            }
        }
    }
    fun register(name:String,email: String,password: String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){

                currentUser = auth.currentUser
                var user_map = hashMapOf(
                    "name" to name,
                    "email" to email,
                    "password" to password,
                    "uid" to currentUser?.uid.toString()
                )
                db.collection("users").add(user_map).addOnCompleteListener {
                    if (it.isSuccessful){
                        println("Register Success")
                        user = User(user_map.get("name"),user_map.get("email"),user_map.get("password"),user_map.get("uid"))
                    }
                    else{
                        println("Registiration Failed")
                    }
                }
            }
            else{
                println("Registiration Failed")
            }
        }
    }

    fun getMessages(messageList:SnapshotStateList<Message>){
        GlobalScope.launch {
            db.collection("messages").orderBy("date",
                Query.Direction.DESCENDING).addSnapshotListener(EventListener { value, error ->
                if (value != null) {
                    for (message in value.documentChanges){
                        println(message.document.data.get("message"))
                        messageList.add(Message(message.document.data.get("message") as String,
                            message.document.data.get("uid") as String))
                    }

                }
            })
        }

    }
    fun sendMessage(message:String){
        var msg = hashMapOf(
            "message" to message,
            "uid" to user.uid,
            "time" to FieldValue.serverTimestamp()
        )
        GlobalScope.launch {
            db.collection("messages").add(msg).addOnCompleteListener {
                if (it.isSuccessful){
                    println("Message send")
                }
            }
        }

    }
}


