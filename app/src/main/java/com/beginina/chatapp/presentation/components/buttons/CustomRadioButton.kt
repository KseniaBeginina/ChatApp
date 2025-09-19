package com.beginina.chatapp.presentation.components.buttons

import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.beginina.chatapp.ui.theme.Blue
import com.beginina.chatapp.ui.theme.MiddleGray

@Composable
fun CustomRadioButton(
    isSelectedState: MutableState<Boolean>
){
    RadioButton(
        selected = isSelectedState.value,
        onClick = {
            isSelectedState.value = !isSelectedState.value
        },
        colors = RadioButtonDefaults.colors(
            selectedColor = Blue,
            unselectedColor = MiddleGray
        )
    )
}

@Composable
@Preview(showBackground = true)
fun CheckCustomRadioButton(){
    var checkedState = remember { mutableStateOf(true) }
    CustomRadioButton(
        checkedState
    )
}