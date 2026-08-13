package com.example.basics.A_Fundamental

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CTF(){

    var textstate by remember {
        mutableStateOf("")
    }

    val myColor = Color(0xFFD50000)

    TextField(value = textstate,
       onValueChange = {textstate =it },
        modifier = Modifier.padding(16.dp),
        label = { Text("Your Name") },
        leadingIcon = {
            Icon(
                Icons.Default.Email,
                contentDescription = "Email icon"
            )
        },
        trailingIcon = {
            Icon(Icons.Default.Send,
                contentDescription = "null")
        },
        colors = TextFieldDefaults.colors(
            unfocusedLabelColor = myColor,
            focusedLabelColor = myColor.copy(.3f),
            cursorColor = myColor,
            focusedLeadingIconColor = myColor,
            unfocusedLeadingIconColor = myColor,
            unfocusedTrailingIconColor = myColor,
            focusedTrailingIconColor = myColor,
            focusedIndicatorColor = myColor,
            unfocusedIndicatorColor = myColor,
            unfocusedTextColor = myColor,
            focusedTextColor = myColor,
//            focusedContainerColor = myColor.copy(.2f),
            // this is also a kind of styling by trasparenting the background
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = myColor.copy(.2f),

        ),
        shape = RoundedCornerShape(16.dp)
        // we can add many shapes we want to add like cutcornershape and many more
        // check by pressing ctrl+space
        
    )

}

@Preview(showBackground = true)
@Composable
fun PreviewCTF(){
    CTF()

}