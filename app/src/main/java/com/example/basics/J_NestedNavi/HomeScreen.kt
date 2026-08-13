package com.example.basics.J_NestedNavi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.basics.J_NestedNavi.Navigation.DoubleBackToExit
import com.example.basics.J_NestedNavi.Navigation.Screens

@Composable
fun HomeSc(navController: NavController) {

    DoubleBackToExit()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text("Home Screen", fontSize = 35.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(40.dp))

        Button(onClick = {

            navController.navigate(Screens.ScreenARoute.route)

        })
        {
            Text("Go to Screen A", fontSize = 25.sp)

        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = {

            navController.navigate(Screens.ScreenBRoute.route)

        })
        {
            Text("Go to Screen B", fontSize = 25.sp)

        }


    }
}