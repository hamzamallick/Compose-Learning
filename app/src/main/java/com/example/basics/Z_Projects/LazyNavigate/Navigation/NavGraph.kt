package com.example.basics.Z_Projects.LazyNavigate.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.basics.Z_Projects.LazyNavigate.Screens.DetailedScreen
import com.example.basics.Z_Projects.LazyNavigate.Screens.MainSc
import com.example.basics.Z_Projects.LazyNavigate.Screens.imageId
import com.example.basics.Z_Projects.LazyNavigate.Screens.itemIngredients
import com.example.basics.Z_Projects.LazyNavigate.Screens.itemName

@Composable
fun NavigationItem() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "HomeScreen"
    ) {

        composable(
            route = "HomeScreen"
        ) {

            MainSc(
                imgId = imageId,
                names = itemName,
                ingredients = itemIngredients,
                navController = navController
            )
        }

        composable(
            route = "DetailScreen/{index}",
            arguments = listOf(
                navArgument("index") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val index = backStackEntry.arguments?.getInt("index")

            DetailedScreen(
                photos = imageId,
                names = itemName,
                ingredients = itemIngredients,
                itemIndex = index
            )
        }
    }
}