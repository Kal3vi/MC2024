package com.example.mc2024.UserInterface

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mc2024.MCAppState
import com.example.mc2024.UserInterface.Reminder.Reminder
import com.example.mc2024.UserInterface.chat.Chat
import com.example.mc2024.UserInterface.home.Home
import com.example.mc2024.UserInterface.login.Login
import com.example.mc2024.UserInterface.settings.Settings
import com.example.mc2024.rememberMCAppState

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
        composable(route = "reminder") {
            Reminder(onBackPress = appState::navigateBack)
        }
        composable(route = "settings"){
            Settings(onBackPress = appState::navigateBack)
        }
    }
}