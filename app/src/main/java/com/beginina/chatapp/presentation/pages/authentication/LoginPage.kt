package com.beginina.chatapp.presentation.pages.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.beginina.chatapp.navigation.Routes
import com.beginina.chatapp.presentation.components.buttons.FilledButton
import com.beginina.chatapp.presentation.components.inputs.EmailTextField
import com.beginina.chatapp.presentation.components.inputs.PasswordTextField
import com.beginina.chatapp.ui.theme.Black
import com.beginina.chatapp.ui.theme.Blue
import com.beginina.chatapp.ui.theme.White
import com.beginina.chatapp.ui.theme.bold24
import com.beginina.chatapp.ui.theme.medium14
import com.beginina.chatapp.ui.theme.semibold12
import com.beginina.chatapp.ui.theme.semibold16

@Composable
fun LoginPage(
    navController: NavController
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 16.dp, vertical = 120.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                })
            },
        verticalArrangement = Arrangement.spacedBy(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            modifier = Modifier
                .wrapContentSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Добро пожаловать!",
                style = bold24,
                color = Black
            )
            Text(
                text = "Мы рады видеть вас снова!",
                style = medium14,
                color = Black
            )
        }

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Text(
                text = "Данные аккаунта",
                style = semibold16,
                color = Black
            )
            EmailTextField(
                emailState = emailState
            ) {
                emailState.value = it
            }
            PasswordTextField(
                passwordState = passwordState
            ) {
                passwordState.value = it
            }
            Text(
                text = "Забыли пароль?",
                style = semibold12,
                color = Blue
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            FilledButton(
                text = "Войти"
            ) {
                //TODO LOGIN
            }

            val annotatedString = buildAnnotatedString {
                append("Нет аккаунта? ")
                withStyle (style = SpanStyle(color = Blue)){
                    withLink (
                        link = LinkAnnotation.Clickable(
                            tag = "registration",
                            linkInteractionListener = {
                                navController.navigate(Routes.CHATS)
                                //TODO to registration
                            }
                        )
                    ){
                        append("Зарегистрируйтесь")
                    }
                }
            }
            Text(
                text = annotatedString
            )
        }
    }
}