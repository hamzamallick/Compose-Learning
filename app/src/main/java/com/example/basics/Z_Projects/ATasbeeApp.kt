package com.example.basics.Z_Projects


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basics.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Tasbee() {

    var count by remember {
        mutableStateOf(0)
    }

    val tasbeehList = listOf(
        "لَا إِلَٰهَ إِلَّا ٱللَّٰهُ مُحَمَّدٌ رَسُولُ ٱللَّٰهِ",
        "سُبْحَانَ ٱللَّٰهِ",
        "ٱلْحَمْدُ لِلَّٰهِ",
        "ٱللَّٰهُ أَكْبَرُ",
        "لَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّٰهِ"
    )

    var currentIndex by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(R.color.tasbee)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = tasbeehList[currentIndex],
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )





        Text(
            "$count",
            modifier = Modifier.padding(top = 20.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )



        IconButton(onClick = { count++ }) {
            Icon(Icons.Default.Add, contentDescription = "")
        }


        Spacer(Modifier.size(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            IconButton(onClick = {
                if (currentIndex > 0) {
                    currentIndex--
                    count = 0
                }
            }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "")
            }

            IconButton(onClick = {
                if (currentIndex < tasbeehList.lastIndex) {
                    currentIndex++
                    count = 0
                }
            }) {
                Icon(Icons.Default.ArrowForward, contentDescription = "")
            }


        }


    }

}

@Preview(showSystemUi = true)
@Composable
fun Tasbeepreview() {
    Tasbee()
}