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
import androidx.navigation.NavHostController
import com.example.basics.J_NestedNavi.Navigation.Screens

@Composable
fun ForgetPssSc(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Forget Screen", fontSize = 35.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(40.dp))

        Button(onClick = {

            navController.navigate(Screens.ScreenLoginRoute.route)

        })
        {
            Text("Forget (Go to Login)", fontSize = 25.sp)

        }
    }

}