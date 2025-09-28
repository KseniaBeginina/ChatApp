package com.beginina.chatapp.navigation

import androidx.compose.ui.graphics.painter.Painter

data class BottomBarItem(
    val route: String,
    val icon: Painter,
    val title: String
)
