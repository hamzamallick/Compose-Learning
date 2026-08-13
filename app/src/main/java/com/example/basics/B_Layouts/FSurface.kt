package com.example.basics.B_Layouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SurfaceExample() {

    Surface(
        modifier = Modifier
            .height(150.dp)
            .width(200.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        color = Color.Yellow,
        border = BorderStroke(5.dp, Color.Red)
    ) {

        Text(
            "Hey this is Hamza",
            fontSize = 26.sp,
            modifier = Modifier.padding(5.dp, 20.dp, 5.dp, 5.dp),
            textAlign = TextAlign.Center
        )


    }

}

@Composable
fun ButtonExp(){
    var count by remember {
        mutableStateOf(0)
    }

    Column(){

        Button(onClick = {
            count++
        }) {
            Text("Count ${count}")
        }

        Spacer(modifier = Modifier.size(20.dp))

        Text("Count ${count}")

    }


}

@Preview(showSystemUi  = true)
@Composable
fun SurfacePreview() {
    ButtonExp()

}