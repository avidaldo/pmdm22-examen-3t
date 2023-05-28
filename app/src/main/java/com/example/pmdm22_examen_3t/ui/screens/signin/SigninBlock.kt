package com.example.pmdm22_examen_3t.ui.screens.signin

import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.pmdm22_examen_3t.R

private const val MIN_SIZE_USERNAME = 4
private const val MIN_SIZE_PASSWORD = 4
fun String.isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SigninBlock(
    alreadySignedUsername: Boolean,
    clearAlreadySignedUserName: () -> Unit,
    alreadySignedEmail: Boolean,
    clearAlreadySignedEmail: () -> Unit,
    signIn: (String, String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var username by rememberSaveable { mutableStateOf("") }
    var emailString by rememberSaveable { mutableStateOf("") }
    var passwordString by rememberSaveable { mutableStateOf("") }
    var passwordRepeatString by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier.background(MaterialTheme.colorScheme.primaryContainer)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                shape = RoundedCornerShape(10.dp)
            ).padding(vertical = 50.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 10.dp, alignment = Alignment.CenterVertically
        ),
    ) {
        OutlinedTextField(
            value = username, onValueChange = {
                username = it.trim()
                clearAlreadySignedUserName()
            },
            label = { Text(text = stringResource(R.string.user_name)) },
            isError = alreadySignedUsername
        )
        OutlinedTextField(
            value = emailString, onValueChange = {
                emailString = it.trim()
                clearAlreadySignedEmail()
            },
            label = { Text(text = stringResource(R.string.email)) },
            isError = alreadySignedEmail
        )
        OutlinedTextField(
            value = passwordString, onValueChange = { passwordString = it },
            label = { Text(text = stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        OutlinedTextField(
            value = passwordRepeatString, onValueChange = { passwordRepeatString = it },
            label = { Text(text = stringResource(R.string.repeat_password)) },
            isError = passwordRepeatString.isNotEmpty() && passwordRepeatString != passwordString,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        Button(
            onClick = { signIn(username, emailString, passwordString) },
            enabled = username.length >= MIN_SIZE_USERNAME && emailString.isValidEmail() &&
                    passwordString.length >= MIN_SIZE_PASSWORD && passwordRepeatString == passwordString
        ) {
            Text(text = stringResource(R.string.sign_in))
        }
    }
}