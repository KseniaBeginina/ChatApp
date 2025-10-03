package com.beginina.chatapp.presentation.components.inputs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DateTextField(
    dateState: MutableState<String>,
    maxWidth: Float = 1F,
    onValueChange:(String)->Unit
){
    BaseTextField(
        textState = dateState,
        placeholder = "01.01.1991",
        height = 54.dp,
        maxWidth = maxWidth,
        keyboardType = KeyboardType.Number,
        visualTransformation = DateVisualTransformation(),
        onValueChange = onValueChange
    )
}

@Composable
@Preview(showBackground = true)
fun CheckDateTextField(){
    var checkedState = remember { mutableStateOf("01011991") }
    DateTextField(
        checkedState
    ) { }
}