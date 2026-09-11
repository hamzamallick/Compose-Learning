package com.example.basics.Z_Projects

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun MyApp() {

    val scrollState = rememberScrollState()

    val isScrolled by remember {
        derivedStateOf {
            scrollState.value == 0
        }
    }

    Log.i("ScrollStateValue", "Current:${scrollState.value}, max: ${scrollState.maxValue}")



    Scaffold(
        Modifier.fillMaxSize(),
        topBar = {

            AnimatedVisibility(visible = isScrolled,
                exit = slideOutVertically() + fadeOut(),
                enter = slideInHorizontally()
            ) {
                TopAppBar(
                    title = {
                        Text(
                            "Top App Bar",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Black
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Black
                    )
                )
            }

        },
        content = { paddingValues ->
            mainUi(scrollState, paddingValues)
        }
    )

}

@Composable
fun mainUi(scrollState: ScrollState, paddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .verticalScroll(scrollState)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Text("1", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text("2", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Text("3", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Text("4", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text("5", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(Color.Magenta),
            contentAlignment = Alignment.Center
        ) {
            Text("6", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text("7", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Text("8", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text("9", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Text("10", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text("11", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text("12", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Text("13", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text("14", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Text("15", fontSize = 42.sp, fontWeight = FontWeight.Bold)
        }

    }
}