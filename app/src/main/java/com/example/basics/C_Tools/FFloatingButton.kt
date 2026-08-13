package com.example.basics.C_Tools

import android.text.Layout
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun FloatingButton(){
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        ExtendedFloatingActionButton(
            onClick = {
                Toast.makeText(context, "Hey User", Toast.LENGTH_SHORT).show()

            },


            content = {
                Text("Extended Button")
            }
        )

    }




}

@Preview(showSystemUi = true)
@Composable
fun PreviewFloatingButton(){
    FloatingButton()
}