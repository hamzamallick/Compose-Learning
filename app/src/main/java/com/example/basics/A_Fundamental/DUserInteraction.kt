package com.example.basics.A_Fundamental

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview


// Below are the function which help us to select the given text
// means which text we can copy and which we cant like this way
@Composable
fun PartiallySelectableText(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        SelectionContainer {
            Column {
                Text("This is selectable text")
                Text("This one is also selectable text")
                Text("Below one are not selectable but this line is")

                DisableSelection {
                    Text("From here text cant be selected")
                    Text("this one is also not selectable")
                }
            }

        }
    }
}


// Below are the concept of how we can add the link into desired way

@Composable
fun AnnotatedStringListnerSample(){

    val uriHandler = LocalUriHandler.current

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(
            buildAnnotatedString {
                append("Build better apps faster with \n")
                val link = LinkAnnotation.Url(
                    "https://developer.android.com/compose",
                    TextLinkStyles(
                        SpanStyle(
                            color = Color.Blue
                        )
                    )

                ){
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }

                withLink(link){
                    append("JetPack Compose")
                }
            }
        )

    }


}

@Preview(showSystemUi = true)
@Composable
fun PreviewFun(){
    AnnotatedStringListnerSample()
}