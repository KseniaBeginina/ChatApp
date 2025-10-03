package com.beginina.chatapp.presentation.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.ui.theme.Blue
import com.beginina.chatapp.ui.theme.White
import com.beginina.chatapp.ui.theme.semibold16

@Composable
fun FilledButton(
    text: String,
    backgroundColor: Color = Blue,
    textColor: Color = White,
    onClick: () -> Unit
){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        onClick = { onClick() }
    ){
        Text(
            text = text,
            style = semibold16
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CheckFilledButton(){
    FilledButton(
        text = "Регистрация"
    ){}
}