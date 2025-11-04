package com.ort.tp3parcialgrupo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.ort.tp3parcialgrupo5.navigation.AppNavGraph
import com.ort.tp3parcialgrupo5.ui.theme.TP3ParcialGrupo5Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TP3ParcialGrupo5Theme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}

