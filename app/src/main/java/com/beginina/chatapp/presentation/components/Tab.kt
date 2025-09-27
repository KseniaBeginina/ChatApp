package com.beginina.chatapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.ui.theme.Blue
import com.beginina.chatapp.ui.theme.Gray
import com.beginina.chatapp.ui.theme.subtitle

@Composable
fun Tab(
    text: String,
    isSelectedState: MutableState<Boolean>,
    onClick: () -> Unit
){
    Column (
        modifier = Modifier
            .height(28.dp)
            .width(IntrinsicSize.Min)
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ){
        Text(
            text = text,
            style = subtitle,
            color = if (isSelectedState.value) Blue else Gray
        )

        if (isSelectedState.value){
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 2.dp,
                color = if (isSelectedState.value) Blue else Gray
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CheckTab(){
    var checkedState = remember { mutableStateOf(true) }
    Tab(
        "lol",
        checkedState
    ){}
}