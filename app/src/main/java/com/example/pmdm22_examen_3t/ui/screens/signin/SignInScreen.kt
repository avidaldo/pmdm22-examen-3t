package com.example.pmdm22_examen_3t.ui.screens.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pmdm22_examen_3t.R
import com.example.pmdm22_examen_3t.ui.state.DialogKind
import com.example.pmdm22_examen_3t.ui.state.ClientsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(vm: ClientsViewModel) {

    Scaffold(topBar = {
        TopAppBar(title = { Text(stringResource(R.string.signin)) },
            modifier = Modifier.padding(end = 10.dp),
            actions = { Text(text = stringResource(R.string.signed_clients, vm.clientList.size)) })
    }) { paddingValues ->
        Column(
            Modifier.padding(paddingValues).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            SigninBlock(
                alreadySignedUsername = vm.alreadySignedUsername,
                clearAlreadySignedUserName = { vm.clearAlreadySignedUserName() },
                alreadySignedEmail = vm.alreadySignedEmail,
                clearAlreadySignedEmail = { vm.clearAlreadySignedEmail() },
                signIn = { username, email, password -> vm.signIn(username, email, password) }
            )

            vm.dialog?.let {
                ResultDialog(
                    titleString =
                    if (it == DialogKind.CORRECT) stringResource(R.string.correctly_signed)
                    else stringResource(id = R.string.credentials_already_in_use),
                    onConfirm = { vm.hideDialog() })
            }
        }
    }
}