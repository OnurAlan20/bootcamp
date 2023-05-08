package com.onuralan.bootcamp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onuralan.bootcamp.Screens

@Composable
fun ChatScreen(bootCampViewModel: BootCampViewModel,navController: NavController){
    bootCampViewModel.getMessages(bootCampViewModel.messageList)


    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xB9F3E6E6)) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Column(modifier = Modifier.fillMaxHeight(0.8f)) {
                LazyColumn{
                    items(bootCampViewModel.messageList){item ->

                        Column(
                                        modifier = Modifier.fillMaxSize().padding(horizontal = 9.dp, vertical = 9.dp),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.Start
                        ) {
                                        Text(text = item.name, fontSize = 21.sp, color = Color(
                                            0xFFCC4317
                                        )
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(text = item.message, fontSize = 18.sp,color = Color(
                                            0xFF161514
                                        )
                                        )
                        }


                    }
                }


            }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                OutlinedTextField(
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp),
                    value = bootCampViewModel.message.value,
                    colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color(
                        0xFFD14C21
                    )
                    ),
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon", tint = Color(0xFFD14C21)) },
                    onValueChange = {
                        bootCampViewModel.message.value = it
                    },
                    label = { Text(text = "Green Chat", fontSize = 18.sp,color = Color(0xFFD14C21)) },
                    placeholder = { Text(text = "Green Chat",fontSize = 18.sp,color = Color(0xFFD14C21)) },
                    trailingIcon = { Icon(
                        Icons.Rounded.Send,
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            bootCampViewModel.sendMessage(bootCampViewModel.message.value)
                            bootCampViewModel.message.value = ""
                        }

                    )}
                )
                Spacer(modifier = Modifier.height(15.dp))
                BottomAppBar(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = contentColorFor(backgroundColor = MaterialTheme.colors.primary),
                    elevation = AppBarDefaults.BottomAppBarElevation,
                ) {

                    BottomNavigation {
                        BottomNavigationItem(
                            selected = true,
                            onClick = { navController.navigate(Screens.MainScreen.route) },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.AccountBox,
                                    contentDescription = "",
                                    tint = contentColorFor(backgroundColor = MaterialTheme.colors.primary)
                                )
                            }
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { navController.navigate(Screens.ChatScreen.route) },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.MailOutline,
                                    contentDescription = "",
                                    tint = contentColorFor(backgroundColor = MaterialTheme.colors.primary)
                                )
                            }
                        )
                    }

                }

            }
        }

    }
}

@Preview
@Composable
fun defaultChatScreen(){
    //ChatScreen(bootCampViewModel = BootCampViewModel())
}
