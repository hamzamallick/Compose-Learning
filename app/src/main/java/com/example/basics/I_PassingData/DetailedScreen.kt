package com.example.basics.I_PassingData

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailedSc(myName : String?,myAge : Int?){

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Detailed Screen", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(45.dp))

        Text("Your name is $myName", fontSize = 25.sp)

        Spacer(modifier = Modifier.height(30.dp))

        Text("Your name is $myAge", fontSize = 25.sp)

    }

}