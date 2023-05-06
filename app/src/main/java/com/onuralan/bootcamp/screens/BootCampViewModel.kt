package com.onuralan.bootcamp.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BootCampViewModel:ViewModel(){
    var loginEmail = mutableStateOf("")
    var loginPassword = mutableStateOf("")
    var registerName = mutableStateOf("")
    var registerEmail = mutableStateOf("")
    var registerPassword = mutableStateOf("")
}


