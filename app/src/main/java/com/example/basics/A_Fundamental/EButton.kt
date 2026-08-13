package com.example.basics.A_Fundamental

import android.graphics.Paint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview



// Filled Button basic one
@Composable
fun FilledButton(){

    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        Button(onClick = {
            Toast.makeText(context, "Button is Clicked", Toast.LENGTH_SHORT).show()

        }) {

            Text("Filled Button")
        }
    }



}


// Tonal Button
@Composable
fun TonalButton(){

    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        FilledTonalButton(onClick = {
            Toast.makeText(context, "Tonal Button is Clicked", Toast.LENGTH_SHORT).show()
        }) {

            Text("Tonal Button")
        }
    }

}



// Outline Button
@Composable
fun OutlineButton(){
    val content = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        OutlinedButton(onClick = {

        }) {
            Text("Outline Button")
        }
    }
}


// Elevated Button
@Composable
fun ElevatedButton(){
    val content = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        ElevatedButton(onClick = {}) {
            Text("Elevated Button")
        }
    }
}


// Text Button
@Composable
fun TextButton(){
    val content = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        TextButton(onClick = {}) {
            Text("Click Here")
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun PreviewButton(){
    ElevatedButton()
}