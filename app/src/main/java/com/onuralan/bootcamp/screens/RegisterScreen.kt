package com.onuralan.bootcamp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterScreen(bootCampViewModel: BootCampViewModel){
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFE7E4E4)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(200.dp))
            Text(text = "Register", fontSize = 45.sp, style = TextStyle.Default, color = Color(0xFFD33F10), fontWeight = FontWeight.Bold )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.fillMaxWidth(),
                value = bootCampViewModel.registerName.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color(
                    0xFFD14C21
                )
                ),
                leadingIcon = { Icon(imageVector = Icons.Default.AccountBox, contentDescription = "emailIcon", tint = Color(0xFFD14C21)) },
                onValueChange = {
                    bootCampViewModel.registerName.value = it
                },
                label = { Text(text = "User Name", fontSize = 18.sp,color = Color(0xFFD14C21)) },
                placeholder = { Text(text = "Enter your User Name",fontSize = 18.sp,color = Color(0xFFD14C21)) },
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.fillMaxWidth(),
                value = bootCampViewModel.registerEmail.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color(
                    0xFFD14C21
                )
                ),
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon", tint = Color(0xFFD14C21)) },
                onValueChange = {
                    bootCampViewModel.registerEmail.value = it
                },
                label = { Text(text = "Email", fontSize = 18.sp,color = Color(0xFFD14C21)) },
                placeholder = { Text(text = "Enter your Email",fontSize = 18.sp,color = Color(0xFFD14C21)) },
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.fillMaxWidth(),
                value = bootCampViewModel.registerPassword.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color(0xFFD14C21)),
                leadingIcon = { Icon(imageVector = Icons.Default.Star, contentDescription = "emailIcon", tint = Color(0xFFD14C21)) },
                onValueChange = {
                    bootCampViewModel.registerPassword.value = it
                },
                label = { Text(text = "Enter Your Password", fontSize = 18.sp,color = Color(0xFFD14C21)) },
                placeholder = { Text(text = "Enter Your Password",fontSize = 18.sp,color = Color(0xFFD14C21)) },
            )

            Spacer(modifier = Modifier.height(35.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(300.dp),
                elevation = ButtonDefaults.elevation(4.dp),
                colors = ButtonDefaults.outlinedButtonColors(Color(0xFFC22C2C)),
                shape = RoundedCornerShape(15.dp),


                ) {
                Text(text = "Log In",fontSize = 30.sp, style = TextStyle.Default, color = Color.Black)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Text(text = "Don't you have an account?",
                    style = TextStyle.Default, color = Color.DarkGray,
                    fontSize = 18.sp,

                    modifier = Modifier
                        .padding(end = 10.dp)
                        .clickable {})
            }
        }

    }
}

@Preview
@Composable
fun DefaultRegisterScreen(){
    RegisterScreen(bootCampViewModel = BootCampViewModel() )
}