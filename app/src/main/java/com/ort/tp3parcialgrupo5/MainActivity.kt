package com.ort.tp3parcialgrupo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.ort.tp3parcialgrupo5.ui.theme.TP3ParcialGrupo5Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP3ParcialGrupo5Theme {
                Surface {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val myFont = FontFamily.Default
    Text(text = "Hello $name!", fontFamily = myFont)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TP3ParcialGrupo5Theme {
        Greeting("Android")
    }
}
