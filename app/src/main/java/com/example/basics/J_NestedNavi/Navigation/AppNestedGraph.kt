package com.example.basics.J_NestedNavi.Navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.basics.J_NestedNavi.HomeSc
import com.example.basics.J_NestedNavi.ScreenA
import com.example.basics.J_NestedNavi.ScreenB


fun NavGraphBuilder.appGraph(navController: NavController){

    navigation(startDestination = Screens.ScreenHomeRoute.route, route = Screens.AppRoute.route){

        composable(route = Screens.ScreenHomeRoute.route) {
            HomeSc(navController = navController)
        }
        composable(route = Screens.ScreenARoute.route) {
            ScreenA(navController = navController)
        }
        composable(route = Screens.ScreenBRoute.route) {
            ScreenB(navController = navController)
        }

    }

}



