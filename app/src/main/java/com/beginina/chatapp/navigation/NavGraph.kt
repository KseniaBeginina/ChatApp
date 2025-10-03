package com.beginina.chatapp.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.beginina.chatapp.R
import com.beginina.chatapp.presentation.pages.ChatsPage
import com.beginina.chatapp.presentation.pages.authentication.LoginPage
import com.beginina.chatapp.presentation.pages.authentication.OnboardingPage
import com.beginina.chatapp.presentation.pages.authentication.RegistrationPage
import com.beginina.chatapp.ui.theme.Black
import com.beginina.chatapp.ui.theme.MiddleGray
import com.beginina.chatapp.ui.theme.MiddleGrayLight
import com.beginina.chatapp.ui.theme.White
import com.beginina.chatapp.ui.theme.semibold12

@Composable
fun NavGraph(startDestination: String){
    val navController = rememberNavController()
    val bottomBarState = remember { mutableStateOf(true) }

    val bottomBarItems = listOf(
        BottomBarItem(route = Routes.CHATS, icon = painterResource(R.drawable.message), title = stringResource(R.string.bbi_messages)),
        BottomBarItem(route = Routes.CONTACTS, icon = painterResource(R.drawable.users), title = stringResource(R.string.bbi_contacts)),
        BottomBarItem(route = Routes.PROFILE, icon = painterResource(R.drawable.user_circle), title = stringResource(R.string.bbi_profile))
    )

    Scaffold (
        bottomBar = {
            if (bottomBarState.value){
                BottomNavigation(
                    backgroundColor = White,
                    elevation = BottomNavigationDefaults.Elevation,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(1.dp, MiddleGrayLight, RoundedCornerShape(16.dp))
                ){
                    val backStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = backStackEntry?.destination?.route

                    bottomBarItems.forEach{ item ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    painter = item.icon,
                                    tint = if (currentRoute == item.route) Black else MiddleGray,
                                    contentDescription = item.route
                                )
                            },
                            label = {
                                Text(
                                    text = item.title,
                                    style = semibold12,
                                    color = if (currentRoute == item.route) Black else MiddleGray
                                )
                            },
                            selected = currentRoute == item.route,
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {saveState = true}
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ){
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(it)
        ){
            composable(Routes.ONBOARDING){
                OnboardingPage(
                    navController = navController
                )
                bottomBarState.value = false
            }
            composable(Routes.LOGIN){
                LoginPage(
                    navController = navController
                )
                bottomBarState.value = false
            }
            composable(Routes.REGISTRATION){
                RegistrationPage(
                    navController = navController
                )
                bottomBarState.value = false
            }
            composable(Routes.CHATS){
                ChatsPage()
                bottomBarState.value = true
            }
        }
    }
}