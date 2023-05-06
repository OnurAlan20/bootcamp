package com.onuralan.bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.onuralan.bootcamp.screens.BootCampViewModel
import com.onuralan.bootcamp.screens.LoginScreen
import com.onuralan.bootcamp.ui.theme.BootcampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bcvm = BootCampViewModel()
        bcvm.initFirebase()
        setContent {
            BootcampTheme {
                LoginScreen(bootCampViewModel = bcvm)
            }
        }
    }
}

