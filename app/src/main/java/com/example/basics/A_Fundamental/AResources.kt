package com.example.basics.A_Fundamental

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.basics.R

@Composable
fun ResourcesAccess(){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = stringResource(R.string.name),
            color = colorResource(R.color.newColor))

        Image(painter = painterResource(R.drawable.settings), contentDescription = "Setting")
    }

}

@Preview(showSystemUi = true)
@Composable
fun Preview(){
    ResourcesAccess()
}