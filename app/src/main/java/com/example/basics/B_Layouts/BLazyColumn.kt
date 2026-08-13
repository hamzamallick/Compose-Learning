package com.example.basics.B_Layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

// Lazy column is horizontal scrollable list


@Composable
fun LazyColumnExample(){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Text("LazyColumn ")

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)


        ) {
            items(100){ index->

                Text(
                    text = "Item $index in LazyColumn",
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.White)
                )

            }
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun PreviewLazyColumn(){
    LazyColumnExample()
}