package com.beginina.chatapp.presentation.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.ui.theme.Black
import com.beginina.chatapp.ui.theme.LightGray
import com.beginina.chatapp.ui.theme.MiddleGrayLight
import com.beginina.chatapp.ui.theme.button

@Composable
fun UnfilledButton(
    text: String,
    onClick: () -> Unit
){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = LightGray,
            contentColor = Black
        ),
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, MiddleGrayLight),
        shape = RoundedCornerShape(4.dp),
        onClick = { onClick() }
    ){
        Text(
            text = text,
            style = button
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CheckUnfilledButton(){
    UnfilledButton(
        text = "Отмена"
    ){}
}