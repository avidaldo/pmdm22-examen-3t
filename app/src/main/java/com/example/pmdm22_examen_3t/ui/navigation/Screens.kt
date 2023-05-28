package com.example.pmdm22_examen_3t.ui.navigation

sealed class Screens(val route: String){
    object MainScreen: Screens("initial_screen")
    object SignInScreen: Screens("signin_screen")
    object ListScreen: Screens("list_screen")
}
