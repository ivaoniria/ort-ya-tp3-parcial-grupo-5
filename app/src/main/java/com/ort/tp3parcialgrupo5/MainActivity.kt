package com.ort.tp3parcialgrupo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.ort.tp3parcialgrupo5.presentation.components.BottomNavItem
import com.ort.tp3parcialgrupo5.presentation.components.BottomNavigationBar
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.HomePageScreen
import com.ort.tp3parcialgrupo5.presentation.home_page.transaction.TransactionScreen
import com.ort.tp3parcialgrupo5.ui.theme.TP3ParcialGrupo5Theme
import com.ort.tp3parcialgrupo5.ui.theme.BackgroundContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TP3ParcialGrupo5Theme {
                val navController = rememberNavController()
                val navItems = listOf(
                    BottomNavItem("Home", R.drawable.home, "home"),
                    BottomNavItem("Analytics", R.drawable.search, "analytics"),
                    BottomNavItem("Transactions", R.drawable.transactions, "transactions"),
                    BottomNavItem("Layers", R.drawable.category, "layers"),
                    BottomNavItem("Profile", R.drawable.profile, "profile")
                )

                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = BackgroundContainer, bottomBar = {

                    val currentDestination = navController
                        .currentBackStackEntryAsState().value?.destination?.route

                    BottomNavigationBar(
                        items = navItems,
                        selectedRoute = currentDestination ?: "home",
                        onItemSelected = { route ->
                            navController.navigate(route) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") { HomePageScreen() }
                        composable("transactions") { TransactionScreen() }
                        // TODO: Aca se configuran las screens que forman parte de la navegacion del BottomNavBar
                        //composable("profile") { ProfilePageScreen() }
                        //composable("category") { CategoryPageScreen() }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TP3ParcialGrupo5Theme {
        Greeting("Android")
    }
}