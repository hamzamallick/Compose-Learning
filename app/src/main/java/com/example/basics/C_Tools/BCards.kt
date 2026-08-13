package com.example.basics.C_Tools

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ElevatedCard() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        ElevatedCard(
            elevation = CardDefaults.cardElevation(12.dp),
            modifier = Modifier.size(width = 200.dp, height = 100.dp),
        ) {
            //We are using box for the alignment of the items inside the card
           Box(
               modifier = Modifier.fillMaxSize(),
               contentAlignment = Alignment.Center
           ) {
               Text("This is Elevated Card")
           }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCard() {
    ElevatedCard()
}