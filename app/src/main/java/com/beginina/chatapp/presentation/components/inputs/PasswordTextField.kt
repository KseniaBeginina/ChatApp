package com.beginina.chatapp.presentation.components.inputs

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.R

@Composable
fun PasswordTextField(
    passwordState: MutableState<String>,
    maxWidth: Float = 1F,
    onValueChange:(String)->Unit
){
    val hideState = remember { mutableStateOf(true) }
    BaseTextField(
        textState = passwordState,
        placeholder = stringResource(R.string.tf_password),
        height = 54.dp,
        maxWidth = maxWidth,
        keyboardType = KeyboardType.Password,
        visualTransformation = if (hideState.value) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Icon(
                painter = painterResource(id = if (hideState.value) R.drawable.eye_close else R.drawable.eye_open),
                contentDescription = "hide",
                modifier = Modifier.clickable {
                    hideState.value = !hideState.value
                }
            )
        },
        onValueChange = onValueChange
    )
}

@Composable
@Preview(showBackground = true)
fun CheckPasswordTextField(){
    var checkedState = remember { mutableStateOf("") }
    PasswordTextField(
        checkedState
    ) { }
}