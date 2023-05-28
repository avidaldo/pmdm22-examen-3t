package com.example.pmdm22_examen_3t.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pmdm22_examen_3t.ui.screens.MenuScreen
import com.example.pmdm22_examen_3t.ui.screens.signin.SignInScreen
import com.example.pmdm22_examen_3t.ui.screens.list_users.ClientsListScreen
import com.example.pmdm22_examen_3t.ui.state.ClientsViewModel

@Composable
fun Navigation(viewModel: ClientsViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) { MenuScreen(navController) }
        composable(route = Screens.SignInScreen.route) { SignInScreen(viewModel) }
        composable(route = Screens.ListScreen.route) { ClientsListScreen(viewModel) }
    }
}