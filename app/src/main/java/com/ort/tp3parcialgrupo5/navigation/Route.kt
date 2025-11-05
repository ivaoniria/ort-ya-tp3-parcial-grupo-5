package com.ort.tp3parcialgrupo5.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Route {
    @Serializable
    data object LaunchInitial : Route()

    @Serializable
    data object LaunchWelcome : Route()

    @Serializable
    data class Onboarding(val loginType: String) : Route()

    @Serializable
    data object SignUp : Route()

    @Serializable
    data object Login : Route()

    @Serializable
    data object Home : Route()

    @Serializable
    data object Transactions : Route()

    @Serializable
    data object Notifications : Route()

    @Serializable
    data object AccountBalance : Route()

    @Serializable
    data object Categories : Route()

    @Serializable
    data class Profile(val userCreated: Boolean = false, val fromLogin: Boolean = false) : Route()

    @Serializable
    data object ForgotResetPassword : Route()

    @Serializable
    data object SecurityPin : Route()

    @Serializable
    data object NewPassword : Route()

    @Serializable
    data object PasswordChanged : Route()
}

@Serializable
data class DBUserDetails(
    val id: Int,
    val username: String,
    val email: String
)
