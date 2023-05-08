package com.onuralan.bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.onuralan.bootcamp.network.sendGPTPropt
import com.onuralan.bootcamp.screens.*
import com.onuralan.bootcamp.ui.theme.BootcampTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

sealed class Screens(val route: String){
    object LoginScreen: Screens("login_screen")
    object RegisterScreen: Screens("register_screen")
    object MainScreen: Screens("main_screen")
    object ChatScreen: Screens("chat_screen")


}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var bcvm = BootCampViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            BootcampTheme {
                val navController = rememberNavController()
                bcvm.initController()
                bcvm.initFirebase()
                bcvm.navController = rememberNavController()
               com.onuralan.bootcamp.navigation.Navigation(bootCampViewModel = bcvm,navController)
            }
        }
    }

}

@Composable
fun Navigation(navHostController: NavHostController){


}

