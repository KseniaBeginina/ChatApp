package com.beginina.chatapp.presentation.components.inputs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PhoneTextField(
    phoneState: MutableState<String>,
    maxWidth: Float = 1F,
    onValueChange:(String)->Unit
){
    BaseTextField(
        textState = phoneState,
        placeholder = "+7(987)654-32-10",
        height = 54.dp,
        maxWidth = maxWidth,
        maxLines = 1,
        keyboardType = KeyboardType.Phone,
        visualTransformation = PhoneNumberVisualTransformation(),
        onValueChange = {onValueChange(it)}
    )
}

@Composable
@Preview(showBackground = true)
fun CheckPhoneTextField(){
    var checkedState = remember { mutableStateOf("79873393619") }
    PhoneTextField(
        checkedState
    ) { }
}