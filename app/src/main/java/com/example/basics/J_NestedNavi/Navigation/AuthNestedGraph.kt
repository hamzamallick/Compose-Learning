package com.example.basics.J_NestedNavi.Navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.basics.J_NestedNavi.ForgetPssSc
import com.example.basics.J_NestedNavi.LoginSc
import com.example.basics.J_NestedNavi.RegisterSc

fun NavGraphBuilder.authGraph(navController: NavController){

    navigation(startDestination = Screens.ScreenLoginRoute.route, route = Screens.AuthRoute.route){

        composable(route = Screens.ScreenLoginRoute.route) {
            LoginSc(navController = navController)
        }
        composable(route = Screens.ScreenRegisterRoute.route) {
            RegisterSc(navController = navController)
        }
        composable(route = Screens.ScreenForgetRoute.route) {
            ForgetPssSc(navController = navController)
        }
    }

}