package com.onuralan.bootcamp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.type.Money
import com.onuralan.bootcamp.R
import com.onuralan.bootcamp.Screens
import com.onuralan.bootcamp.network.sendGPTPropt
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun MainScreen(bootCampViewModel: BootCampViewModel,navController: NavController){



    Surface(modifier = Modifier
        .fillMaxSize(),
        color = Color(0x88FFFFFF)
    ) {

        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Image(
                    painter = painterResource(id = R.drawable.green),
                    contentDescription = "Resim Açıklaması",
                    modifier = Modifier.size(200.dp) // Resim boyutunu ayarlamak için gerekli
                )

                Text(
                    text = bootCampViewModel.gptResponse.value,
                    fontSize = 20.sp,
                    color = Color(0xFFD14C21),
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp)
                )
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp),
                    value = bootCampViewModel.gptRequest.value,
                    colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color(
                        0xFFD14C21
                    )
                    ),
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon", tint = Color(0xFFD14C21)) },
                    onValueChange = {
                        bootCampViewModel.gptRequest.value = it
                    },
                    label = { Text(text = "Green AI", fontSize = 18.sp,color = Color(0xFFD14C21)) },
                    placeholder = { Text(text = "Green AI",fontSize = 18.sp,color = Color(0xFFD14C21)) },
                    trailingIcon = { Icon(
                        Icons.Rounded.Send,
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            GlobalScope.launch {
                                bootCampViewModel.gptResponse.value = sendGPTPropt(bootCampViewModel.gptRequest.value)!!
                            }

                        }
                    )}
                )
                Spacer(modifier = Modifier.height(12.dp))

                BottomAppBar(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = contentColorFor(backgroundColor = MaterialTheme.colors.primary),
                    elevation = AppBarDefaults.BottomAppBarElevation,
                ) {



                    BottomNavigation {
                        BottomNavigationItem(
                            selected = true,
                            onClick = { navController.navigate(Screens.MainScreen.route)/* Home ikonuna tıklama işlemleri burada gerçekleştirilebilir */ },
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
                            onClick = { navController.navigate(Screens.ChatScreen.route)/* Para ikonuna tıklama işlemleri burada gerçekleştirilebilir */ },
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
fun DefaultPreview(){
    //MainScreen(bootCampViewModel = BootCampViewModel())
}



