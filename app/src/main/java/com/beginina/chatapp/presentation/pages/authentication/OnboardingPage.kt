package com.beginina.chatapp.presentation.pages.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.beginina.chatapp.R
import com.beginina.chatapp.navigation.Routes
import com.beginina.chatapp.presentation.components.buttons.FilledButton
import com.beginina.chatapp.ui.theme.Black
import com.beginina.chatapp.ui.theme.White
import com.beginina.chatapp.ui.theme.b1
import com.beginina.chatapp.ui.theme.bottomBar
import com.beginina.chatapp.ui.theme.h1
import com.beginina.chatapp.ui.theme.logo

@Composable
fun OnboardingPage(
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(90.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                modifier = Modifier
                    .wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier.size(60.dp),
                    painter = painterResource( id = R.drawable.logo),
                    contentDescription = null
                )

                Column {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = logo,
                        color = Black
                    )
                    Text(
                        text = stringResource(R.string.slogan),
                        style = bottomBar,
                        color = Black
                    )
                }
            }

            Image(
                modifier = Modifier.size(240.dp),
                painter = painterResource( id = R.drawable.onboarding),
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = stringResource(R.string.welcome),
                    style = h1,
                    color = Black
                )
                Text(
                    text = stringResource(R.string.welcome_slogan),
                    style = b1,
                    color = Black
                )
            }

            FilledButton(
                text = stringResource(R.string.welcome_button)
            ) {
                navController.navigate(Routes.LOGIN){
                    popUpTo(Routes.ONBOARDING){
                        inclusive = true
                    }
                }
            }
        }
    }
}