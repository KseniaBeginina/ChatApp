package com.beginina.chatapp.presentation.components.buttons

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.beginina.chatapp.ui.theme.Blue
import com.beginina.chatapp.ui.theme.MiddleGrayLight
import com.beginina.chatapp.ui.theme.White

@Composable
fun CustomCheckbox(
    isCheckedState: MutableState<Boolean>
){
    Checkbox(
        colors = CheckboxDefaults.colors(
            checkedColor = Blue,
            checkmarkColor = White,
            uncheckedColor = MiddleGrayLight
        ),
        checked = isCheckedState.value,
        onCheckedChange = {
            isCheckedState.value = !isCheckedState.value
        }
    )
}

@Composable
@Preview(showBackground = true)
fun CheckCustomCheckbox(){
    var checkedState = remember { mutableStateOf(false) }
    CustomCheckbox(
        checkedState
    )
}