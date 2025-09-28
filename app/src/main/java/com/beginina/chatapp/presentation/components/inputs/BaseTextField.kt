package com.beginina.chatapp.presentation.components.inputs

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.ui.theme.Black
import com.beginina.chatapp.ui.theme.MiddleGrayLight
import com.beginina.chatapp.ui.theme.White
import com.beginina.chatapp.ui.theme.subtitle

@Composable
fun BaseTextField(
    textState: MutableState<String>,
    placeholder: String,
    height: Dp,
    maxWidth: Float = 1F,
    maxLines: Int,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    onValueChange:(String)->Unit
){
    TextField(
        modifier = Modifier
            .fillMaxWidth(maxWidth)
            .height(height)
            .border(1.dp, MiddleGrayLight, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp)),
        placeholder = {
            Text(
                text = placeholder,
                color = MiddleGrayLight
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon,
        textStyle = subtitle,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = White,
            unfocusedTextColor = MiddleGrayLight,
            unfocusedIndicatorColor = MiddleGrayLight,
            unfocusedLeadingIconColor = MiddleGrayLight,
            unfocusedTrailingIconColor = MiddleGrayLight,
            focusedContainerColor = White,
            focusedTextColor = Black,
            focusedIndicatorColor = MiddleGrayLight,
            focusedLeadingIconColor = Black,
            focusedTrailingIconColor = Black,
        ),
        value = textState.value,
        maxLines = maxLines,
        onValueChange = {onValueChange(it)}
    )
}