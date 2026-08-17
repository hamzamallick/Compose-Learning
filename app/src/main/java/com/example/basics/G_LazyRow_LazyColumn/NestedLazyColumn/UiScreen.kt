package com.example.basics.G_LazyRow_LazyColumn.NestedLazyColumn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basics.R

private val parentItemList = ArrayList<ParentDataClass>()

@Composable
fun MyBooks(
    modifier: Modifier = Modifier.Companion,
    parentItemList: ArrayList<ParentDataClass>
) {
    LazyColumn(contentPadding = PaddingValues(15.dp)) {
        items(parentItemList.size) {
            ColumnItemUi(
                modifier = Modifier,
                parentList = parentItemList,
                itemIndex = it

            )
        }

    }
}

private fun setData() {

    val images = listOf(
        ChildDataClass(R.drawable.book1),
        ChildDataClass(R.drawable.book2),
        ChildDataClass(R.drawable.book3),
        ChildDataClass(R.drawable.book4),
        ChildDataClass(R.drawable.book5),
        ChildDataClass(R.drawable.book6),
        ChildDataClass(R.drawable.book7),
        ChildDataClass(R.drawable.book8),
        ChildDataClass(R.drawable.book9),
        ChildDataClass(R.drawable.book10),
        ChildDataClass(R.drawable.book11),
        ChildDataClass(R.drawable.book12),
        ChildDataClass(R.drawable.book13),
        ChildDataClass(R.drawable.book14),
        ChildDataClass(R.drawable.book15),
        ChildDataClass(R.drawable.book16)
    )
    parentItemList.add(ParentDataClass("Novel:", images))
    parentItemList.add(ParentDataClass("Best Sellers:", images.shuffled()))
    parentItemList.add(ParentDataClass("History:", images.shuffled()))
    parentItemList.add(ParentDataClass("Favourite:", images.reversed()))
    parentItemList.add(ParentDataClass("Crime:", images.shuffled()))
    parentItemList.add(ParentDataClass("Drama:", images))
    parentItemList.add(ParentDataClass("New Topics:", images.shuffled()))


}


@Composable
fun ColumnItemUi(
    itemIndex: Int,
    parentList: ArrayList<ParentDataClass>,
    modifier: Modifier.Companion
) {

    Card(
        modifier.padding(12.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )
    ) {
        Text(
            parentList[itemIndex].title,
            modifier.padding(12.dp),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Yellow
        )


        LazyRow(
            modifier.padding(paddingValues = PaddingValues(12.dp))
        ) {
            items(parentList[itemIndex].childList.size) {
                RowItemUi(
                    modifier = Modifier,
                    childList = parentList[itemIndex].childList,
                    itemIndex = it
                )
            }
        }

    }

}

@Composable
fun RowItemUi(
    modifier: Modifier.Companion,
    childList: List<ChildDataClass>,
    itemIndex: Int
) {

    Box(
        modifier
            .height(200.dp)
            .width(160.dp)
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xff201e1e))
    ) {

        Image(
            painter = painterResource(id = childList[itemIndex].image),
            contentDescription = null,
            modifier.fillMaxSize()
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun MyPreview() {

    setData()

    MyBooks(
        modifier = Modifier,
        parentItemList = parentItemList
    )


}