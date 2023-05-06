package com.onuralan.bootcamp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuralan.bootcamp.R

@Composable
fun MainScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFE7E4E4))) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name), color = Color.White) },
                backgroundColor = Color(0xFFD14C21),
                elevation = 4.dp,
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                    }
                }
            )

            
        }


    }
}

@Preview
@Composable
fun DefaultMainScreen(){
    MainScreen()
}

