package com.example.basics.A_Fundamental

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SimpleText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Hey this is Hamza \n and just started learning Compose\n",
            color = Color.Blue,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ColorfulText() {
    val rainbowColor = listOf(
        Color.Blue,
        Color.Red,
        Color.Yellow,
        Color.Cyan,
        Color.Green,
        Color.Black,
        Color.Magenta
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = buildAnnotatedString {
                append("Do not allow people to dim you shine\n")
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColor
                        )
                    )
                ) {
                    append("because they are blinded.\n")

                }
                append("tell them to put some glasses on")
            }
        )
    }
}

@Composable
fun AnimatedText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Hey this is Hamza learning Compose from scratch (Basic to Advance)",
            modifier = Modifier.basicMarquee(),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TextDesign() {
    Text(text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontSize = 25.sp
            )
        ) {
            append("J")
        }

        append("etpack")

        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontSize = 25.sp
            )
        ) {
            append("C")
        }


        append("ompose")
    })
}


@Preview(showSystemUi = true)
@Composable
fun TextPreview() {
    TextDesign()
}