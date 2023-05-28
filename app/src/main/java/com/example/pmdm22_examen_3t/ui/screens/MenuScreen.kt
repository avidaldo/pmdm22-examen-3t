package com.example.pmdm22_examen_3t.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.pmdm22_examen_3t.R
import com.example.pmdm22_examen_3t.ui.navigation.Screens

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { navController.navigate(route = Screens.SignInScreen.route) }) {
            Text(text = stringResource(R.string.signin_clients_option))
        }
        Button(onClick = { navController.navigate(route = Screens.ListScreen.route) }) {
            Text(text = stringResource(R.string.clients_management_option))
        }
    }
}