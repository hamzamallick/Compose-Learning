package com.example.basics.I_PassingData

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeSc(navController: NavHostController) {

    var nameValue by remember {
        mutableStateOf("")
    }
    var ageValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            "Home Screen",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(45.dp))

        TextField(
            value = nameValue,
            onValueChange = { nameValue = it },
            Modifier.padding(10.dp),
            placeholder = {
                Text("Enter your name")
            }

        )
        TextField(
            value = ageValue,
            onValueChange = { ageValue = it },
            Modifier.padding(10.dp),
            placeholder = {
                Text("Enter your age")
            }

        )

        Button(onClick = {


            // below code will crash the app if user will leave any of the entry empty

//            navController.navigate("Details/$nameValue/$ageValue")

            // to avoid this issue we will change the little bit

            navController.navigate("Details?name=$nameValue&age=$ageValue")

        }) {
            Text("Pass Data", fontSize = 25.sp)
        }

    }


}

