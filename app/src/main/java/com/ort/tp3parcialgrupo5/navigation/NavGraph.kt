package com.ort.tp3parcialgrupo5.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.account_balance.AccountBalanceScreen
import com.ort.tp3parcialgrupo5.presentation.categories.CategoriesScreen
import com.ort.tp3parcialgrupo5.presentation.components.BottomNavItem
import com.ort.tp3parcialgrupo5.presentation.components.BottomNavigationBar
import com.ort.tp3parcialgrupo5.presentation.home_screen.HomePageScreen
import com.ort.tp3parcialgrupo5.presentation.launch.LaunchInitialScreen
import com.ort.tp3parcialgrupo5.presentation.launch.LaunchWelcomeScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.forgot_reset_password.ForgotResetPasswordScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.CreateAccountScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.LoginScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.NewPasswordScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.PasswordChangedScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.SecurityPinScreen
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

    NavHost(
        navController = navController,
        startDestination = Route.LaunchInitial,
        modifier = Modifier.fillMaxSize()
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
                onForgot = {
                    navController.navigate(Route.Onboarding("forgot")) {
                        popUpTo<Route.LaunchWelcome>() { inclusive = true }
                    }
                }
            )
        }

        composable<Route.Onboarding> { backStackEntry ->
            val args = backStackEntry.toRoute<Route.Onboarding>()
            OnboardingScreen(
                onFinish = {
                    when (args.loginType) {
                        "login" -> {
                            navController.navigate(Route.Home) {
                                popUpTo<Route.LaunchInitial>() { inclusive = true }
                            }
                        }
                        "signup" -> {
                            navController.navigate(Route.SignUp) {
                                popUpTo<Route.LaunchInitial>() { inclusive = true }
                            }
                        }
                        "forgot" -> {
                            navController.navigate(Route.ForgotResetPassword) {
                                popUpTo<Route.LaunchInitial>() { inclusive = true }
                            }
                        }
                        else -> {
                            navController.navigate(Route.Home) {
                                popUpTo<Route.LaunchInitial>() { inclusive = true }
                            }
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
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onSignUpClick = {
                    navController.navigate(Route.Onboarding("signup")) {
                        popUpTo<Route.Login>() { inclusive = true }
                    }
                },
                onForgotClick = {
                    navController.navigate(Route.Onboarding("forgot")) {
                        popUpTo<Route.Login>() { inclusive = true }
                    }
                }
            )
        }

        composable<Route.CreateAccount> {
            CreateAccountScreen(
                onSignUpSuccess = {
                    navController.navigate(Route.Profile(userCreated = true)) {
                        popUpTo<Route.LaunchInitial>() { inclusive = true }
                    }
                },
                onLoginClick = {
                    navController.navigate(Route.Login) {
                        popUpTo<Route.CreateAccount>() { inclusive = true }
                    }
                }
            )
        }

        composable<Route.Home> {
            val selected = Route.Home::class.qualifiedName
            WithBottomBar(navController, navItems, selected) {
                HomePageScreen(onBell = { navController.navigate(Route.Notifications) })
            }
        }

        composable<Route.Profile> { backStackEntry ->
            val args = backStackEntry.toRoute<Route.Profile>()
            val selected = Route.Profile(fromLogin = true)::class.qualifiedName
            WithBottomBar(navController, navItems, selected) {
                ProfileScreen(
                    userCreated = args.userCreated,
                    fromLogin = args.fromLogin,
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate(Route.Notifications) },
                    onLoggedOut = {
                        navController.navigate(Route.LaunchWelcome) {
                            popUpTo(navController.graph.findStartDestination().id) { inclusive = true }
                            launchSingleTop = true
                            restoreState = false
                        }
                    }
                )
            }
        }

        composable<Route.Transactions> {
            val selected = Route.Transactions::class.qualifiedName
            WithBottomBar(navController, navItems, selected) {
                TransactionScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate(Route.Notifications) }
                )
            }
        }

        composable<Route.AccountBalance> {
            val selected = Route.AccountBalance::class.qualifiedName
            WithBottomBar(navController, navItems, selected) {
                AccountBalanceScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate(Route.Notifications) }
                )
            }
        }

        composable<Route.Categories> {
            val selected = Route.Categories::class.qualifiedName
            WithBottomBar(navController, navItems, selected) {
                CategoriesScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate(Route.Notifications) }
                )
            }
        }

        composable<Route.Notifications> {
            val selected: String? = null
            WithBottomBar(navController, navItems, selected) {
                NotificationScreen(
                    onBack = { navController.popBackStack() },
                    onBell = { navController.navigate(Route.Notifications) }
                )
            }
        }

        composable<Route.ForgotResetPassword> {
            ForgotResetPasswordScreen(
                onSignUpClick = {
                    navController.navigate(Route.SignUp) {
                        popUpTo<Route.LaunchInitial>() { inclusive = false }
                    }
                },
                onNextStep = {
                    navController.navigate(Route.SecurityPin)
                }
            )
        }

        composable<Route.SecurityPin> {
            SecurityPinScreen(
                onAccept = {
                    navController.navigate(Route.NewPassword)
                },
                onSignUp = {
                    navController.navigate(Route.CreateAccount)
                }
            )
        }

        composable<Route.NewPassword> {
            NewPasswordScreen(
                onPasswordChanged = {
                    navController.navigate(Route.PasswordChanged) {
                        popUpTo<Route.LaunchInitial>() { inclusive = false }
                    }
                }
            )
        }

        composable<Route.PasswordChanged> {
            PasswordChangedScreen(
                onFinish = {
                    navController.navigate(Route.Home) {
                        popUpTo<Route.LaunchInitial>() { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
private fun WithBottomBar(
    navController: NavHostController,
    navItems: List<BottomNavItem>,
    selectedRoute: String?,
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = navItems,
                selectedRoute = selectedRoute,
                onItemSelected = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(Modifier.padding(top = innerPadding.calculateTopPadding())) {
            content()
        }
    }
}
