package com.example.basics.F_NavigationDrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basics.R
import kotlinx.coroutines.launch


@Composable
fun MyApp() {


}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun NavDrawer() {

    val drawerItem = listOf(
        DrawerItem(Icons.Default.Face, "Profile", 0, false),
        DrawerItem(Icons.Default.Email, "Email", 17, true),
        DrawerItem(Icons.Default.Favorite, "Favourite", 2, true),
        DrawerItem(Icons.Default.Settings, "Setting", 0, false),
    )
    var selectedItem by remember {
        mutableStateOf(drawerItem[0])
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .fillMaxHeight()
                    .background(Color.White),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.Yellow),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        Modifier.wrapContentSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.akshay_kumar),
                            contentDescription = null,
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape)
                        )

                        Text(
                            "Akshay Kumar",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                        )
                    }

                    Divider(
                        Modifier.align(Alignment.BottomCenter),
                        thickness = 1.dp,
                        Color.DarkGray
                    )

                }

                drawerItem.forEach {
                    NavigationDrawerItem(
                        label = { Text(text = it.text) },
                        selected = it == selectedItem,
                        onClick = {
                            selectedItem = it
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        modifier = Modifier.padding(horizontal = 10.dp),
                        icon = {
                            Icon(it.icon, null)
                        },
                        badge = {
                            if (it.hasBadge) {
                                Badge {
                                    Text(
                                        text = it.badgeCount.toString(),
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }
                    )
                }

            }
        },
        drawerState = drawerState
    ) {


        Scaffold(topBar = {
            TopAppBar(
                title = {
                    Text("Drawer Menu")
                },
                navigationIcon = {
                    IconButton(onClick = {

                        scope.launch {
                            drawerState.open()
                        }

                    }) {
                        Icon(Icons.Filled.Menu, null)
                    }
                }
            )
        }) { paddingValues ->

            Box(
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {


                Button(onClick = {
                    scope.launch {
                        drawerState.open()
                    }

                }) {

                    Text("Open Drawer")
                }
            }


        }


    }

}

data class DrawerItem(
    val icon: ImageVector,
    val text: String,
    val badgeCount: Int,
    val hasBadge: Boolean
)