package com.example.basics.G_LazyRow_LazyColumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val languages = listOf(
    "Java",
    "Python",
    "C",
    "C++",
    "Kotlin",
    "Dart",
    "PHP",
    "XML",
    "HTML",
    "JavaScript",
    "R",
    "Go",
    "Swift"
)

@Composable
fun MyApp(modifier: Modifier= Modifier, languages: List<String>){

    Column(modifier = modifier.fillMaxSize()) {
        LazyRow(modifier = Modifier.padding(top = 25.dp)) {
            items(languages){ item->
                RowItems(item)

            }
        }

        LazyColumn(modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            items(languages){ item->
                ColumnItems(item)

            }

        }
    }
}

@Composable
fun RowItems(name: String){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(120.dp)
            .aspectRatio(1.5f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ColumnItems(name: String){
    Card(
        modifier = Modifier
            .padding(6.dp)
            .wrapContentHeight()
            .aspectRatio(3f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun PreviewLRLC() {
    MyApp(languages = languages)


}