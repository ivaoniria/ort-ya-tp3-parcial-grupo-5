package com.ort.tp3parcialgrupo5.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.categories.CategoriesScreen
import com.ort.tp3parcialgrupo5.presentation.home_screen.HomePageScreen
import com.ort.tp3parcialgrupo5.presentation.launch.LaunchInitialScreen
import com.ort.tp3parcialgrupo5.presentation.launch.LaunchWelcomeScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.LoginScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.CreateAccountScreen
import com.ort.tp3parcialgrupo5.presentation.notification.NotificationScreen
import com.ort.tp3parcialgrupo5.presentation.on_boarding.OnboardingScreen
import com.ort.tp3parcialgrupo5.presentation.transaction.TransactionScreen
import com.ort.tp3parcialgrupo5.presentation.components.BottomNavItem
import com.ort.tp3parcialgrupo5.presentation.components.BottomNavigationBar

@Composable
fun AppNavGraph(navController: NavHostController) {
    val navItems = listOf(
        BottomNavItem("Home", R.drawable.home, "home"),
        BottomNavItem("Analytics", R.drawable.search, "analytics"),
        BottomNavItem("Transactions", R.drawable.transactions, "transactions"),
        BottomNavItem("Layers", R.drawable.category, "layers"),
        BottomNavItem("Profile", R.drawable.profile, "profile")
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            val currentDestination = navController
                .currentBackStackEntryAsState().value?.destination?.route

            if (currentDestination in listOf("home", "transactions", "notifications", "layers")) {
                BottomNavigationBar(
                    items = navItems,
                    selectedRoute = currentDestination ?: "home",
                    onItemSelected = { route ->
                        when (route) {
                            "home" -> {
                                navController.navigate("home") {
                                    popUpTo(navController.graph.startDestinationId) {
                                        inclusive = false
                                    }
                                    launchSingleTop = true
                                }
                            }
                            "transactions" -> {
                                navController.navigate("transactions") {
                                    popUpTo(navController.graph.startDestinationId) {
                                        inclusive = false
                                    }
                                    launchSingleTop = true
                                }
                            }
                            "layers" -> {
                                navController.navigate("layers") {
                                    popUpTo(navController.graph.startDestinationId) {
                                        inclusive = false
                                    }
                                    launchSingleTop = true
                                }
                            }
                            else -> {
                                navController.navigate(route) {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "launch_initial",
            modifier = Modifier.padding(innerPadding)
        ) {
            // Flujo de Launch
            composable("launch_initial") {
                LaunchInitialScreen(
                    onFinished = { navController.navigate("launch_welcome") }
                )
            }

            composable("launch_welcome") {
                LaunchWelcomeScreen(
                    onLogin = {
                        navController.navigate("onboarding/login") {
                            popUpTo("launch_welcome") { inclusive = true }
                        }
                    },
                    onSignUp = {
                        navController.navigate("onboarding/signup") {
                            popUpTo("launch_welcome") { inclusive = true }
                        }
                    },
                    onForgot = {
                        // Navegación para recuperar contraseña
                    }
                )
            }

            // Flujo de Onboarding 
            composable("onboarding/{loginType}") { backStackEntry ->
                val loginType = backStackEntry.arguments?.getString("loginType") ?: "login"
                OnboardingScreen(
                    onFinish = {
                        if (loginType == "login") {
                            navController.navigate("login") {
                                popUpTo("launch_initial") { inclusive = true }
                            }
                        } else {
                            navController.navigate("signup") {
                                popUpTo("launch_initial") { inclusive = true }
                            }
                        }
                    }
                )
            }

            // Flujo de Login/SignUp
            composable("login") {
                LoginScreen(
                    onLoginSuccess = {
                        navController.navigate("home") {
                            popUpTo("launch_initial") { inclusive = true }
                        }
                    },
                    onSignUpClick = {
                        navController.navigate("signup")
                    }
                )
            }

            composable("signup") {
                CreateAccountScreen(
                    onSignUpSuccess = {
                        navController.navigate("home") {
                            popUpTo("launch_initial") { inclusive = true }
                        }
                    },
                    onLoginClick = {
                        navController.navigate("login")
                    }
                )
            }

            // Flujo principal con BottomNavBar
            composable("home") {
                HomePageScreen(
                    onBell = { navController.navigate("notifications") }
                )
            }

            composable("transactions") {
                TransactionScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate("notifications") }
                )
            }

            composable("notifications") {
                NotificationScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate("notifications") }
                )
            }

            composable("layers") {
                CategoriesScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate("notifications") }
                )
            }
        }
    }
}


