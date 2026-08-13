package com.example.basics.Z_Projects.LazyNavigate.Screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.basics.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


val itemName = arrayOf(
    "Peperoni",
    "Vegan",
    "FourCheese",
    "Margaritta",
    "American"
)

val imageId = arrayOf(
    R.drawable.p1,
    R.drawable.p2,
    R.drawable.p3,
    R.drawable.p4,
    R.drawable.p5

)

val itemIngredients = arrayOf(
    "Tomato sos, cheese, oregano, peperoni",
    "Tomato sos, cheese, oregano, spinach, green paprika, rukola",
    "Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
    "Tomato sos, cheese, oregano, bazillion",
    "Tomato sos, cheese, oregano, green paprika, red beans"
)

@Composable
fun MainSc(
    imgId: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    LazyColumn(contentPadding = PaddingValues(16.dp)) {

        val itemCount = itemName.size
        items(itemCount){
            ColumnItm(
                itemIndex = it,
                painter = imgId,
                titles = names,
                ingredients = ingredients,
                modifier = Modifier,
                navController = navController


            )
        }



    }



}

@Composable
fun ColumnItm(
    itemIndex: Int,
    painter: Array<Int>,
    titles: Array<String>,
    ingredients: Array<String>,
    navController: NavController,
    modifier: Modifier
) {

    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable(){
                navController.navigate(route = "DetailScreen/$itemIndex")

            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {

        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = titles[itemIndex],
                modifier.size(150.dp)
            )

            Column(
                modifier.padding(8.dp)
            ){
                Text(
                    text = titles[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                )

                Text(
                    text = ingredients[itemIndex],
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 7.dp)
                )


            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewProj(){

}
