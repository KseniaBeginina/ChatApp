package com.beginina.chatapp.presentation.pages.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.R
import com.beginina.chatapp.presentation.components.buttons.FilledButton
import com.beginina.chatapp.presentation.components.inputs.PasswordTextField
import com.beginina.chatapp.ui.theme.Black
import com.beginina.chatapp.ui.theme.Gray
import com.beginina.chatapp.ui.theme.LightGray
import com.beginina.chatapp.ui.theme.bold24
import com.beginina.chatapp.ui.theme.medium14
import com.beginina.chatapp.ui.theme.semibold14

@Composable
fun RegistrationPasswordStep(
    passwordState: MutableState<String>,
    confirmPasswordState: MutableState<String>,
    onFinish: () -> Unit,
    onBack: () -> Unit
) {

    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.reg_step_2),
        style = semibold14,
        color = Gray
    )

    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.reg_step_2_text),
        style = bold24,
        color = Black
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.profile_info_new_pass),
                style = medium14,
                color = Black
            )
            PasswordTextField(
                passwordState = passwordState
            ) {
                passwordState.value = it
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.profile_info_confirm_pass),
                style = medium14,
                color = Black
            )
            PasswordTextField(
                passwordState = confirmPasswordState
            ) {
                confirmPasswordState.value = it
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        FilledButton(
            text = stringResource(R.string.reg_button),
            onClick = onFinish
        )
        FilledButton(
            text = stringResource(R.string.back_button),
            backgroundColor = LightGray,
            textColor = Black,
            onClick = onBack
        )
    }
}