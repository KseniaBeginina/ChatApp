package com.beginina.chatapp.presentation.components.inputs

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.R

@Composable
fun SearchTextField(
    searchState: MutableState<String>,
    maxWidth: Float = 1F,
    onValueChange:(String)->Unit
){
    BaseTextField(
        textState = searchState,
        placeholder = "",
        height = 54.dp,
        maxWidth = maxWidth,
        maxLines = 1,
        keyboardType = KeyboardType.Text,
        visualTransformation = VisualTransformation.None,
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = null
            )
        },
        onValueChange = {onValueChange(it)}
    )
}

@Composable
@Preview(showBackground = true)
fun CheckSearchTextField(){
    var checkedState = remember { mutableStateOf("") }
    SearchTextField(
        checkedState
    ) { }
}