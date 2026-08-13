package com.example.basics.J_NestedNavi.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.rememberNavController



@Composable
fun NavLogin(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.AuthRoute.route) {

        authGraph(navController)

        appGraph(navController)






        ////////////////////////////////////////////




    }

}