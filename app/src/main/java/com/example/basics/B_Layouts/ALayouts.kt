package com.example.basics.B_Layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout


// Column, it allows you to place it's items in vertical way

@Composable
fun ColumnExample() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        Text("Text 1")
        Text("Text 2")
        Text("Text 3")
        Text("Text 4")
    }

}


// Row, it arrange the items in horizontal way

@Composable
fun RowExample() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Text 1")
        Text("Text 2")
        Text("Text 3")
        Text("Text 4")

    }
}


// Box, it is a container in which items overlaps each other (ek ke uper ek aata hai)

@Composable
fun BoxExample() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Yellow),
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Compose", color = Color.White,
                        fontSize = 20.sp
                    )


                }


            }

        }

    }


}


// Constraint Layout, use only when ui is complex

@Composable
fun ConstraintLayoutExample() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)
                .padding(10.dp)
        ) {

            val (text1, text2, text3) = createRefs()

            Text(
                "Bottom Left",
                modifier = Modifier.constrainAs(text1) {
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                "Top Right",
                modifier = Modifier.constrainAs(text2) {
                    end.linkTo(parent.end, margin = 10.dp)
                    top.linkTo(parent.top, margin = 10.dp)


                }
            )

            Text(
                "Center",
                modifier = Modifier.constrainAs(text3) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
            )


        }

    }
}

// Try to avoid over nesting things

@Preview(showSystemUi = true)
@Composable
fun LayoutPreview() {
    ConstraintLayoutExample()
}

