package com.onuralan.bootcamp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.onuralan.bootcamp.Screens
import com.onuralan.bootcamp.screens.*


@Composable
fun Navigation(bootCampViewModel: BootCampViewModel,navController:NavHostController){

    NavHost(navController = navController, startDestination = Screens.LoginScreen.route){
        composable(route = Screens.LoginScreen.route ){
            LoginScreen(bootCampViewModel = bootCampViewModel,navController=navController)
        }
        composable(route =Screens.RegisterScreen.route ){
            RegisterScreen(bootCampViewModel = bootCampViewModel,navController=navController)
        }
        composable(route =Screens.MainScreen.route ){
            MainScreen(bootCampViewModel = bootCampViewModel,navController=navController)
        }
        composable(route =Screens.ChatScreen.route ){
            ChatScreen(bootCampViewModel = bootCampViewModel,navController=navController)
        }
    }

}