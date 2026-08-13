package com.example.basics.J_NestedNavi

import android.app.Activity
import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.basics.J_NestedNavi.Navigation.Screens

@Composable
fun LoginSc(navController: NavController) {

    // Gets the current Android Activity
    val context = LocalContext.current

    // Handle the system Back button
    BackHandler {
        (context as? Activity)?.finish()
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Text("Login Screen", fontSize = 35.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(40.dp))

        Button(onClick = {

            navController.navigate(Screens.ScreenHomeRoute.route)

        })
        {
            Text("Login (Go to Home)", fontSize = 25.sp)

        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = {

            navController.navigate(Screens.ScreenForgetRoute.route)

        })
        {
            Text("Forget Password", fontSize = 25.sp)

        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = {

            navController.navigate(Screens.ScreenRegisterRoute.route)

        })
        {
            Text("Register", fontSize = 25.sp)

        }

    }
}