package com.example.basics.C_Tools

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Search() {

    val list = listOf(
        "Java",
        "Kotlin",
        "C++",
        "C",
        "Python",
        "Ruby",
        "JavaScript",
        "Swift",
        "XML",
        "Dart",
        "Go",
        "R",
        "PHP",
        "Perl",
        "SQL",
        "HTML",
        "CSS"
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val textState = remember {
            mutableStateOf(TextFieldValue(""))
        }

        SearchView(
            state = textState,
            placeHolder = "Search here"
        )

        val searchText = textState.value.text



        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ) {

            items(list.filter {
                it.contains(searchText,ignoreCase = true)
            }, key = {it}){ item->
                ColumnItem(item = item)
            }
        }
    }
}

@Composable
fun ColumnItem(item: String) {

    Column(
        modifier = Modifier.padding(10.dp)
    ) {

        Text(
            text = item,
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 22.sp
        )

        HorizontalDivider()
    }
}

@Composable
fun SearchView(
    state: MutableState<TextFieldValue>,
    placeHolder: String
) {

    TextField(
        value = state.value,

        onValueChange = { value ->
            state.value = value
        },

        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(30.dp))
            .border(
                3.dp,
                Color.DarkGray,
                RoundedCornerShape(30.dp)
            ),

        placeholder = {
            Text(text = placeHolder)
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSearch() {
    Search()
}