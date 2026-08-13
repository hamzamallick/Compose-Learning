package com.example.basics.D_MenuBox

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MenuBox() {

    val context = LocalContext.current

    var expanded by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {

        Box(
            modifier = Modifier.padding(16.dp)
        ) {

            IconButton(
                onClick = {
                    expanded = !expanded

                }) {

                Icon(Icons.Default.MoreVert, contentDescription = "Three Dot")

            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {

                DropdownMenuItem(
                    text = { Text("Profile") },
                    trailingIcon = {Icon(Icons.Outlined.Person, contentDescription = "Profile")},
                    onClick = {
                        // Task you want to assign here like by clicking moving to the next page

                        Toast.makeText(context, "Here is your Profile user", Toast.LENGTH_SHORT).show()

                    }
                )

                DropdownMenuItem(
                    text = { Text("Setting") },
                    trailingIcon = {Icon(Icons.Outlined.Settings, contentDescription = "Setting")},
                    onClick = {
                        // Task you want to assign here like by clicking moving to the next page

                        Toast.makeText(context, "Here is your Setting user", Toast.LENGTH_SHORT).show()

                    }
                )

                HorizontalDivider()


                DropdownMenuItem(
                    text = { Text("LogOut") },
                    trailingIcon = {Icon(Icons.Outlined.Close, contentDescription = "LogOut")},
                    onClick = {
                        // Task you want to assign here like by clicking moving to the next page

                        Toast.makeText(context, "Your Profile is Logged Out", Toast.LENGTH_SHORT).show()

                    }
                )

            }

        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun MenuPreview() {
    MenuBox()
}