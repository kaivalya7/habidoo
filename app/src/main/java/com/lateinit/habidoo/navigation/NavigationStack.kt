package com.lateinit.habidoo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lateinit.habidoo.ui.screens.DashboardScreen
import com.lateinit.habidoo.ui.screens.LauncherScreen

@Composable
fun NavigationStack() {
    NavHost(navController = LocalNavController.current, startDestination = ScreenRouteData.Launcher.route) {
        composable(route = ScreenRouteData.Launcher.route) {
            LauncherScreen()
        }
        composable(
            route = ScreenRouteData.Dashboard.route
        ) {
            DashboardScreen()
        }
    }
}
