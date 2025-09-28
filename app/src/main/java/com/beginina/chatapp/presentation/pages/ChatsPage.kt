package com.beginina.chatapp.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.ui.theme.White

@Composable
fun ChatsPage(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(16.dp),
    ){
        Text("hello chats")
    }
}