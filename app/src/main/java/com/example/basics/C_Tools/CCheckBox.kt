package com.example.basics.C_Tools

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.util.fastForEachIndexed
import kotlinx.serialization.internal.throwMissingFieldException

@Composable
fun CheckBoxExample() {

    val context = LocalContext.current

    val childCheckBoxState = remember {
        mutableStateListOf(false, false, false)
    }

    val parentState = when {
        childCheckBoxState.all { it } -> ToggleableState.On
        childCheckBoxState.none() -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Select All")
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    childCheckBoxState.fastForEachIndexed { index, _ ->
                        childCheckBoxState[index] = newState

                    }
                }
            )

        }

        childCheckBoxState.forEachIndexed { index, checked ->

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Option ${index + 1}")
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        childCheckBoxState[index] = it
                    }
                )

            }

        }
    }

    if (childCheckBoxState.all { it }) {

        Toast.makeText(context, "All options are selected", Toast.LENGTH_SHORT).show()
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewChecked(){
    CheckBoxExample()
}