package com.example.mc2024.UserInterface

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mc2024.UserInterface.payment.Payment
import com.example.mc2024.UserInterface.chat.Chat
import com.example.mc2024.UserInterface.home.Home
import com.example.mc2024.UserInterface.login.Login

@Composable
fun MCApp(
    appState: MCAppState = rememberMCAppState()
) {
    NavHost(
        navController = appState.navController,
        startDestination = "login"
    ) {
        composable(route = "login") {
            Login(navController = appState.navController)
        }
        composable(route = "home") {
            Home(navController = appState.navController)
        }
        composable(route = "chat") {
            Chat(navController = appState.navController)
        }
        composable(route = "payment") {
            Payment(onBackPress = appState::navigateBack)
        }
    }
}