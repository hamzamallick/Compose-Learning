package com.example.basics.C_Tools

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton


import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.basics.R

@Composable
fun AlertDialogExample(

) {

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Dialog(
            onDismissRequest = { }
        )
        {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),


                ) {
                Image(
                    painter = painterResource(R.drawable.settings),
                    contentDescription = "Testing Image",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(150.dp)
                        .align(Alignment.CenterHorizontally)

                )

                Text(
                    "What Action Do You Want To Perform",
                    modifier = Modifier
                        .padding(15.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = {
                        Toast.makeText(context, "You clicked on Confirm", Toast.LENGTH_SHORT).show()
                    }) {
                        Text("Confirm")
                    }

                    TextButton(onClick = {
                        Toast.makeText(context, "You want to dismiss this..?", Toast.LENGTH_SHORT)
                            .show()
                    }) {
                        Text("Dismiss")
                    }
                }


            }

        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun DialogPreview() {
    AlertDialogExample()
}