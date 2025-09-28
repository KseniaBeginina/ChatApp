package com.beginina.chatapp.presentation.components.inputs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleTextField(
    textState: MutableState<String>,
    maxWidth: Float = 1F,
    onValueChange:(String)->Unit
){
    BaseTextField(
        textState = textState,
        placeholder = "",
        height = 54.dp,
        maxWidth = maxWidth,
        maxLines = 1,
        keyboardType = KeyboardType.Text,
        visualTransformation = VisualTransformation.None,
        onValueChange = {onValueChange(it)}
    )
}

@Composable
@Preview(showBackground = true)
fun CheckSimpleTextField(){
    var checkedState = remember { mutableStateOf("") }
    SimpleTextField(
        checkedState
    ) { }
}