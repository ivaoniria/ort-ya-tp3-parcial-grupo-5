package com.ort.tp3parcialgrupo5.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

// ======================
// Paletas base (template)
// ======================
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

// ==================================
// Theme Material por defecto del app
// ==================================
@Composable
fun TP3ParcialGrupo5Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

// =========================================
// Theme FinWise (Launch/Onboarding - dark)
// =========================================
private val FinWiseDarkScheme = darkColorScheme(
    primary = FinBrand,
    onPrimary = FinBtnText,
    background = FinBg,
    surface = FinBg,
    onBackground = FinWhite,
    onSurface = FinWhite
)

@Composable
fun FinWiseTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = FinWiseDarkScheme,
        typography = Typography,
        content = content
    )
}

// ===========================
// Gradiente del Home
// ===========================
@Composable
fun homeGradient(): Brush = Brush.verticalGradient(
    colors = listOf(BgStart, BgEnd)
)

// ==================================================
// Esquema dark usado por la pantalla Home
// ==================================================
private val DarkColors = darkColorScheme(
    primary = CyanAccent,
    onPrimary = Color.White,
    secondary = CyanAccent,
    background = BgEnd,
    surface = TealDark,
    onSurface = Color.White,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = Color.White
)


