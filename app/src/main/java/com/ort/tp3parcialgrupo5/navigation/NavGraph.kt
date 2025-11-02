package com.ort.tp3parcialgrupo5.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ort.tp3parcialgrupo5.presentation.home_page.account_balance.AccountBalanceScreen
import com.ort.tp3parcialgrupo5.presentation.home_page.floating_menu.notification.NotificationScreen
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.HomePageScreen
import com.ort.tp3parcialgrupo5.presentation.home_page.transaction.TransactionScreen
import com.ort.tp3parcialgrupo5.presentation.launch.LaunchInitialScreen
import com.ort.tp3parcialgrupo5.presentation.launch.LaunchWelcomeScreen
import com.ort.tp3parcialgrupo5.presentation.on_boarding.OnboardingScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = Route.LaunchInitial.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Route.LaunchInitial.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        navController.navigate(Route.LaunchWelcome.route) {
                            popUpTo(Route.LaunchInitial.route) { inclusive = true }
                        }
                    }
            ) {
                LaunchInitialScreen(
                    onFinished = { }
                )
            }
        }

        composable(Route.LaunchWelcome.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        navController.navigate(Route.OnBoarding.route) {
                            popUpTo(Route.LaunchWelcome.route) { inclusive = true }
                        }
                    }
            ) {
                LaunchWelcomeScreen(
                    onLogin = { },
                    onSignUp = { },
                    onForgot = { }
                )
            }
        }

        composable(Route.OnBoarding.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        navController.navigate(Route.Home.route) {
                            popUpTo(Route.OnBoarding.route) { inclusive = true }
                        }
                    }
            ) {
                OnboardingScreen(
                    onFinish = { }
                )
            }
        }

        composable(Route.Home.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        navController.navigate(Route.Transaction.route) {
                            popUpTo(Route.Home.route) { inclusive = true }
                        }
                    }
            ) {
                HomePageScreen()
            }
        }

        composable(Route.Transaction.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        navController.navigate(Route.AccountBalance.route) {
                            popUpTo(Route.Transaction.route) { inclusive = true }
                        }
                    }
            ) {
                TransactionScreen(
                    onBack = { },
                    onBell = { }
                )
            }
        }

        composable(Route.AccountBalance.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        navController.navigate(Route.Notification.route) {
                            popUpTo(Route.AccountBalance.route) { inclusive = true }
                        }
                    }
            ) {
                AccountBalanceScreen(
                    onBack = { }
                )
            }
        }

        composable(Route.Notification.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        navController.navigate(Route.LaunchInitial.route) {
                            popUpTo(Route.Notification.route) { inclusive = true }
                        }
                    }
            ) {
                NotificationScreen(
                    onBack = { }
                )
            }
        }
    }
}


