package com.example.basics.Z_Projects.AutoImageSlider

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basics.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
@Preview(showSystemUi = true)
fun MyApp(modifier: Modifier = Modifier) {

    val images = listOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5
    )

    val pagerState = rememberPagerState(pageCount = { images.size })

    val scope = rememberCoroutineScope()

//    LaunchedEffect(Unit) {
//        while (true) {
//            delay(2000)
//            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
//            pagerState.scrollToPage(nextPage)
//        }
//    }

    LaunchedEffect(pagerState.currentPage) {
        delay(2000)

        val nextPage =
            (pagerState.currentPage + 1) % pagerState.pageCount

        pagerState.scrollToPage(nextPage)
    }

//    LaunchedEffect(pagerState.currentPage) {
//        delay(2000)
//
//        val nextPage =
//            (pagerState.currentPage + 1) % pagerState.pageCount
//
//        pagerState.animateScrollToPage(nextPage)
//    }

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier.wrapContentSize()) {
            HorizontalPager(
                state = pagerState,
                modifier
                    .fillMaxWidth()

            ) { currentPage ->
                Card(
                    modifier
                        .fillMaxWidth()
                        .padding(25.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Image(
                        painter = painterResource(images[currentPage]), contentDescription = "",
                        modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            IconButton(
                onClick = {
                    val nextPage = pagerState.currentPage + 1
                    if (nextPage < images.size) {
                        scope.launch {
                            pagerState.scrollToPage(nextPage)
                        }
                    }
                },
                modifier
                    .padding(30.dp)
                    .size(45.dp)
                    .align(Alignment.CenterEnd)
                    .clip(CircleShape),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0x52373737)
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "",
                    modifier.fillMaxSize(),
                    tint = Color.White
                )

            }
            IconButton(
                onClick = {

                    val prevPage = pagerState.currentPage - 1
                    if (prevPage >= 0) {
                        scope.launch {
                            pagerState.scrollToPage(prevPage)
                        }
                    }
                },
                modifier
                    .padding(30.dp)
                    .size(45.dp)
                    .align(Alignment.CenterStart)
                    .clip(CircleShape),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0x52373737)
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                    modifier.fillMaxSize(),
                    tint = Color.White
                )

            }
        }
        PageIndicator(
            pageCount = images.size,
            currentPage = pagerState.currentPage,
            modifier = modifier
        )


    }

}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

        repeat(pageCount) {
            IndicatorDot(isSelected = it == currentPage, modifier = modifier)
        }


    }

}

@Composable
fun IndicatorDot(isSelected: Boolean, modifier: Modifier) {

    val size = animateDpAsState(targetValue = if (isSelected) 12.dp else 8.dp)


    Box(
        modifier = modifier
            .padding(2.dp)
            .size(size.value)
            .clip(CircleShape)
            .background(if (isSelected) Color(0xFF373737) else Color(0x2D373737))
    ) {

    }

}