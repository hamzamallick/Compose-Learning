package com.example.basics.Z_Projects

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.annotations.Nls

@Composable
fun Login() {

    val keyBoardController = LocalSoftwareKeyboardController.current

    val focusManager = LocalFocusManager.current


    var newTextValue by remember {
        mutableStateOf("")
    }

    var newPhoneValue by remember {
        mutableStateOf("")
    }

    var newPassValue by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = newTextValue,
            onValueChange = { newTextValue = it },
            label = { Text("Enter your Email") },
            singleLine = true,
            modifier = Modifier.width(300.dp),
            placeholder = {
                Text("abc@gmail.com")
            },
//            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "")
            },
            trailingIcon = {
                IconButton(onClick = {
                    Toast.makeText(context, newTextValue, Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Default.Check, contentDescription = "")
                }
            }
        )

        Spacer(Modifier.size(15.dp))

        TextField(
            value = newPhoneValue,
            onValueChange = { newPhoneValue = it },
            label = { Text("Enter your Phone Number") },
            singleLine = true,
            modifier = Modifier.width(300.dp),
            placeholder = {
                Text("+919876543219")
            },
//            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(Icons.Default.Call, contentDescription = "")
            },
            trailingIcon = {
                IconButton(onClick = {
                    Toast.makeText(context, newPhoneValue, Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Default.Check, contentDescription = "")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
//                capitalization = KeyboardCapitalization.Characters
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {

                    keyBoardController?.hide()
                }
            )



        )

        Spacer(Modifier.size(15.dp))

        OutlinedTextField(
            value = newPassValue,
            onValueChange = { newPassValue = it },
            label = { Text("Enter your Password") },
            singleLine = true,
            modifier = Modifier.width(300.dp),
            placeholder = {
                Text("*****")
            },
            // this one is use for giving the password like effect
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "")
            },
            trailingIcon = {
                IconButton(onClick = {

                    if (newPassValue == "HamzaMallick") {
                        Toast.makeText(
                            context,
                            "Email: $newTextValue\nPass: $newPassValue",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Wrong Password...! \n $newPassValue is not your Password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }) {
                    Icon(Icons.Default.Send, contentDescription = "")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
//                capitalization = KeyboardCapitalization.Characters
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    focusManager.clearFocus()
                }
            )
        )


    }


}

@Preview(showSystemUi = true)
@Composable
fun PreviewLogin() {

    Login()


}