package com.example.basics.H_NavigationController

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "A"){

        composable(route = "A") {
            ScreenA(navController)
        }

        composable(route = "B") {
            ScreenB(navController)
        }

        composable(route = "C") {
            ScreenC(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNav(){
    Nav()
}