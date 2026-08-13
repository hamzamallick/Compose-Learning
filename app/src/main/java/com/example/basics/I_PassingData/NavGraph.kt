package com.example.basics.I_PassingData

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {

        composable(route = "Home") {
            HomeSc(navController)
        }

        composable(
            //below will lead app crash
//            route = "Details/{name}/{age}"


              route = "Details?name={name}&age={age}",
            arguments = listOf(
                navArgument(name = "name"){
                    type = NavType.StringType
//                    defaultValue = "user"
                    nullable = true
                },
                navArgument(name = "age"){
                    type = NavType.IntType
                    defaultValue = 0

                }
            )
        ) { backstackEntry ->
            DetailedSc(
                myName =backstackEntry.arguments?.getString("name"),
                myAge =backstackEntry.arguments?.getInt("age")
            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewNav() {
    NavGraph()
}