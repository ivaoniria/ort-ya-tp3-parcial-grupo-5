package com.ort.tp3parcialgrupo5.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.account_balance.AccountBalanceScreen
import com.ort.tp3parcialgrupo5.presentation.categories.CategoriesScreen
import com.ort.tp3parcialgrupo5.presentation.components.BottomNavItem
import com.ort.tp3parcialgrupo5.presentation.components.BottomNavigationBar
import com.ort.tp3parcialgrupo5.presentation.home_screen.HomePageScreen
import com.ort.tp3parcialgrupo5.presentation.launch.LaunchInitialScreen
import com.ort.tp3parcialgrupo5.presentation.launch.LaunchWelcomeScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.CreateAccountScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.LoginScreen
import com.ort.tp3parcialgrupo5.presentation.notification.NotificationScreen
import com.ort.tp3parcialgrupo5.presentation.on_boarding.OnboardingScreen
import com.ort.tp3parcialgrupo5.presentation.profile.ProfileScreen
import com.ort.tp3parcialgrupo5.presentation.transaction.TransactionScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    val navItems = listOf(
        BottomNavItem("Home", R.drawable.home, Route.Home),
        BottomNavItem("AccountBalance", R.drawable.search, Route.AccountBalance),
        BottomNavItem("Transactions", R.drawable.transactions, Route.Transactions),
        BottomNavItem("Categories", R.drawable.category, Route.Categories),
        BottomNavItem("Profile", R.drawable.profile, Route.Profile(fromLogin = true))
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route?.substringBefore("?")

            val shouldShowBottomBar = navItems.any { it.route::class.qualifiedName == currentRoute }

            if (shouldShowBottomBar) {
                BottomNavigationBar(
                    items = navItems,
                    selectedRoute = currentRoute,
                    onItemSelected = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.LaunchInitial,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Route.LaunchInitial> {
                LaunchInitialScreen(
                    onFinished = { navController.navigate(Route.LaunchWelcome) }
                )
            }

            composable<Route.LaunchWelcome> {
                LaunchWelcomeScreen(
                    onLogin = {
                        navController.navigate(Route.Onboarding("login")) {
                            popUpTo<Route.LaunchWelcome>() { inclusive = true }
                        }
                    },
                    onSignUp = {
                        navController.navigate(Route.Onboarding("signup")) {
                            popUpTo<Route.LaunchWelcome>() { inclusive = true }
                        }
                    },
                    onForgot = {}
                )
            }

            composable<Route.Onboarding> { backStackEntry ->
                val args = backStackEntry.toRoute<Route.Onboarding>()
                OnboardingScreen(
                    onFinish = {
                        if (args.loginType == "login") {
                            navController.navigate(Route.Home) {
                                popUpTo<Route.LaunchInitial>() { inclusive = true }
                            }
                        } else {
                            navController.navigate(Route.SignUp) {
                                popUpTo<Route.LaunchInitial>() { inclusive = true }
                            }
                        }
                    }
                )
            }

            composable<Route.SignUp> {
                CreateAccountScreen(
                    onSignUpSuccess = {
                        navController.navigate(Route.Profile(userCreated = true)) {
                            popUpTo<Route.LaunchInitial>() { inclusive = true }
                        }
                    },
                    onLoginClick = {
                        navController.navigate(Route.Login) {
                            popUpTo<Route.SignUp>() { inclusive = true }
                        }
                    }
                )
            }

            composable<Route.Login> {
                LoginScreen(
                    onLoginSuccess = {
                        navController.navigate(Route.Home) {
                            popUpTo<Route.LaunchInitial>() { inclusive = true }
                        }
                    },
                    onSignUpClick = {
                        navController.navigate(Route.Onboarding("signup")) {
                            popUpTo<Route.Login>() { inclusive = true }
                        }
                    }
                )
            }

            composable<Route.Home> {
                HomePageScreen(
                    onBell = { navController.navigate(Route.Notifications) }
                )
            }

            composable<Route.Profile> { backStackEntry ->
                val args = backStackEntry.toRoute<Route.Profile>()
                ProfileScreen(
                    userCreated = args.userCreated,
                    fromLogin = args.fromLogin,
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate(Route.Notifications) }
                )
            }

            composable<Route.Transactions> {
                TransactionScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate(Route.Notifications) }
                )
            }

            composable<Route.Notifications> {
                NotificationScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate(Route.Notifications) }
                )
            }

            composable<Route.AccountBalance> {
                AccountBalanceScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate(Route.Notifications) }
                )
            }

            composable<Route.Categories> {
                CategoriesScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate(Route.Notifications) }
                )
            }
        }
    }
}
