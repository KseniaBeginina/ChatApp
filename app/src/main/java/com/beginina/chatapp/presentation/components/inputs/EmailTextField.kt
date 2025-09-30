package com.beginina.chatapp.presentation.components.inputs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.R

@Composable
fun EmailTextField(
    emailState: MutableState<String>,
    maxWidth: Float = 1F,
    onValueChange:(String)->Unit
){
    BaseTextField(
        textState = emailState,
        placeholder = stringResource(R.string.tf_email),
        height = 54.dp,
        maxWidth = maxWidth,
        keyboardType = KeyboardType.Email,
        onValueChange = onValueChange
    )
}

@Composable
@Preview(showBackground = true)
fun CheckEmailTextField(){
    var checkedState = remember { mutableStateOf("") }
    EmailTextField(
        checkedState
    ) { }
}