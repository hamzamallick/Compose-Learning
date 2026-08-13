package com.example.basics.A_Fundamental

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basics.R


@Composable
fun Image() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val rainbowColor = remember {
            Brush.sweepGradient(
                listOf(
                    Color.Blue,
                    Color.Red,
                    Color.Yellow,
                    Color.Cyan,
                    Color.Green,
                    Color.Black,
                    Color.Magenta
                )
            )
        }

        val borderWidth = 4.dp

        Image(
            painter = painterResource(id = R.drawable.location),
            contentDescription = "This is sample image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .border(
                    BorderStroke(borderWidth, rainbowColor),
                    shape = RoundedCornerShape(12.dp)
                )
                .clip(RoundedCornerShape(12.dp))

        )


    }

}


@Preview(showSystemUi = true)
@Composable
fun PreviewImg() {
    Image()
}