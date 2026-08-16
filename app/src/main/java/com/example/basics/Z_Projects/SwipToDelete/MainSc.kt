package com.example.basics.Z_Projects.SwipToDelete

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyApp() {

    val list = remember {
        mutableStateListOf(
            "Hamza",
            "Umar",
            "Shiran",
            "Abbad",
            "Huzaifa"
        )
    }

    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp)
    ) {

        itemsIndexed(
            items = list,
            key = { _, listItem ->
                listItem
            }
        ) { index, item ->

            val state = rememberSwipeToDismissBoxState(
                confirmValueChange = {

                    if (it == SwipeToDismissBoxValue.EndToStart) {
                        list.remove(item)
                    }

                    true
                }
            )

            SwipeToDismissBox(
                state = state,

                backgroundContent = {

                    val color = when (state.dismissDirection) {

                        SwipeToDismissBoxValue.EndToStart -> Color.Red

                        SwipeToDismissBoxValue.StartToEnd -> Color.Green

                        SwipeToDismissBoxValue.Settled -> Color.Transparent
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(10.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {

                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete",
                            modifier = Modifier.align(Alignment.CenterEnd),

                        )
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit",
                            modifier = Modifier.align(Alignment.CenterStart),

                            )
                    }
                }

            ) {

                ItemUi(
                    list = list,
                    itemIndex = index
                )
            }
        }
    }
}


@Composable
fun ItemUi(
    modifier: Modifier = Modifier,
    list: List<String>,
    itemIndex: Int
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {

        Text(
            text = list[itemIndex],
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp)
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewMyApp() {
    MyApp()
}