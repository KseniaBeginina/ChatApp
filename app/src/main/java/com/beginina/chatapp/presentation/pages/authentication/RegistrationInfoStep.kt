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
import com.beginina.chatapp.presentation.components.PhotoEditComponent
import com.beginina.chatapp.presentation.components.buttons.FilledButton
import com.beginina.chatapp.presentation.components.inputs.DateTextField
import com.beginina.chatapp.presentation.components.inputs.EmailTextField
import com.beginina.chatapp.presentation.components.inputs.PhoneTextField
import com.beginina.chatapp.presentation.components.inputs.SimpleTextField
import com.beginina.chatapp.ui.theme.Black
import com.beginina.chatapp.ui.theme.Gray
import com.beginina.chatapp.ui.theme.bold24
import com.beginina.chatapp.ui.theme.medium14
import com.beginina.chatapp.ui.theme.semibold14

@Composable
fun RegistrationInfoStep(
    nameState: MutableState<String>,
    emailState: MutableState<String>,
    phoneState: MutableState<String>,
    birthdayState: MutableState<String>,
    onNext: () -> Unit
) {

    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.reg_step_1),
        style = semibold14,
        color = Gray
    )

    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.reg_step_1_text),
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
                text = stringResource(R.string.profile_info_photo),
                style = medium14,
                color = Black
            )
            PhotoEditComponent()
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.profile_info_name),
                style = medium14,
                color = Black
            )
            SimpleTextField(
                textState = nameState,
                placeholder = stringResource(R.string.tf_name)
            ){
                nameState.value = it
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.profile_info_birthday),
                style = medium14,
                color = Black
            )
            DateTextField(
                dateState = birthdayState
            ){
                birthdayState.value = it
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.profile_info_phone),
                style = medium14,
                color = Black
            )
            PhoneTextField(
                phoneState = phoneState
            ) {
                phoneState.value = it
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.profile_info_email),
                style = medium14,
                color = Black
            )
            EmailTextField(
                emailState = emailState
            ) {
                emailState.value = it
            }
        }
    }
    FilledButton(
        text = stringResource(R.string.next_button),
        onClick = onNext
    )
}