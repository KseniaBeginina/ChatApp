package com.beginina.chatapp.presentation.pages.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.beginina.chatapp.R
import com.beginina.chatapp.navigation.Routes
import com.beginina.chatapp.ui.theme.Blue
import com.beginina.chatapp.ui.theme.White

@Composable
fun RegistrationPage(
    navController: NavController
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    val stepState = remember { mutableStateOf(RegistrationStep.INFO) }

    val nameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val phoneState = remember { mutableStateOf("") }
    val birthdayState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                })
            },
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        when(stepState.value){
            RegistrationStep.INFO -> RegistrationInfoStep(
                nameState = nameState,
                birthdayState = birthdayState,
                phoneState = phoneState,
                emailState = emailState,
                onNext = {stepState.value = RegistrationStep.PASSWORD}
            )
            RegistrationStep.PASSWORD -> RegistrationPasswordStep(
                passwordState = passwordState,
                confirmPasswordState = confirmPasswordState,
                onFinish = {/*TODO registration*/},
                onBack = {stepState.value = RegistrationStep.INFO}
            )
        }

        val annotatedString = buildAnnotatedString {
            append(stringResource(R.string.reg_get_acc)+" ")
            withStyle (style = SpanStyle(color = Blue)){
                withLink (
                    link = LinkAnnotation.Clickable(
                        tag = "registration",
                        linkInteractionListener = {
                            navController.navigate(Routes.LOGIN)
                        }
                    )
                ){
                    append(stringResource(R.string.auth_button))
                }
            }
        }
        Text(
            text = annotatedString
        )
    }
}