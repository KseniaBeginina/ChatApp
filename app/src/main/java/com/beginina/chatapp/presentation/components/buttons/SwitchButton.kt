package com.beginina.chatapp.presentation.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.R
import com.beginina.chatapp.ui.theme.Blue
import com.beginina.chatapp.ui.theme.Gray
import com.beginina.chatapp.ui.theme.LightGray
import com.beginina.chatapp.ui.theme.White

@Composable
fun SwitchButton(
    isCheckedState: MutableState<Boolean>
){
    Switch(
        colors = SwitchDefaults.colors(
            checkedThumbColor = White,
            checkedIconColor = Blue,
            checkedTrackColor = Blue,
            uncheckedThumbColor = White,
            uncheckedBorderColor = LightGray,
            uncheckedTrackColor = LightGray,
        ),
        checked = isCheckedState.value,
        onCheckedChange = {
            isCheckedState.value = !isCheckedState.value
        },
        thumbContent = {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .shadow(
                        elevation = 1.dp,
                        shape = CircleShape,
                        spotColor = Gray
                    )
                    .background(White, CircleShape),
                contentAlignment = Alignment.Center
            ){
                if (isCheckedState.value){
                    Icon(
                        painter = painterResource(R.drawable.check),
                        contentDescription = "check"
                    )
                }
            }

        }
    )
}

@Composable
@Preview(showBackground = true)
fun CheckSwitchButton(){
    var checkedState = remember { mutableStateOf(false) }
    SwitchButton(
        checkedState
    )
}