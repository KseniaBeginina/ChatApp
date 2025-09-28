package com.beginina.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.beginina.chatapp.navigation.NavGraph
import com.beginina.chatapp.navigation.Routes
import com.beginina.chatapp.ui.theme.ChatAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatAppTheme {
                val startDestination = Routes.CHATS
                NavGraph(startDestination = startDestination)
            }
        }
    }
}