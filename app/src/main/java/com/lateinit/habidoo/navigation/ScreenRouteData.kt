package com.lateinit.habidoo.navigation

sealed class ScreenRouteData(val route: String) {
    data object Launcher : ScreenRouteData("launcher_screen")
    data object Dashboard : ScreenRouteData("dashboard_screen")
}
