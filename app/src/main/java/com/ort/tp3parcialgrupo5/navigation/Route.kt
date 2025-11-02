package com.ort.tp3parcialgrupo5.navigation

sealed class Route(val route: String) {
    object LaunchInitial : Route("launch_initial")
    object LaunchWelcome : Route("launch_welcome")
    object OnBoarding : Route("onboarding")
    object Home : Route("home")
    object Transaction : Route("transaction")
    object AccountBalance : Route("account_balance")
    object Notification : Route("notification")
}


