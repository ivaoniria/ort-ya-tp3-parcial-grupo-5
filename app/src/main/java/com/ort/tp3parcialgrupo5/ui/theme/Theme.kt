package com.ort.tp3parcialgrupo5.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// =====================
// Material 3 ColorScheme
// =====================

private val LightColors: ColorScheme = lightColorScheme(
    primary            = MainGreen,
    onPrimary          = PureWhite,
    primaryContainer   = LightGreen,
    onPrimaryContainer = LettersAndIcons,

    secondary          = BlueButton,
    onSecondary        = PureWhite,
    secondaryContainer = LightBlueButton,
    onSecondaryContainer = LettersAndIcons,

    tertiary           = OceanBlueButton,
    onTertiary         = PureWhite,

    background         = BgGreenWhite,
    onBackground       = LettersAndIcons,

    surface            = PureWhite,
    onSurface          = LettersAndIcons,

    surfaceVariant     = LightGreen,
    onSurfaceVariant   = LettersAndIcons,

    outline            = LettersAndIcons.copy(alpha = 0.2f),
    error              = Color(0xFFB3261E),
    onError            = PureWhite
)

private val DarkColors: ColorScheme = darkColorScheme(
    primary            = MainGreen,
    onPrimary          = PureBlack,
    primaryContainer   = DarkModeGreenBar,
    onPrimaryContainer = PureWhite,

    secondary          = BlueButton,
    onSecondary        = PureBlack,
    secondaryContainer = LightBlueButton,
    onSecondaryContainer = PureBlack,

    tertiary           = OceanBlueButton,
    onTertiary         = PureBlack,

    background         = DarkModeGreenBlack,
    onBackground       = PureWhite,

    surface            = BgDarkAndLetters,
    onSurface          = PureWhite,

    surfaceVariant     = DarkModeGreenBar,
    onSurfaceVariant   = PureWhite,

    outline            = PureWhite.copy(alpha = 0.15f),
    error              = Color(0xFFF2B8B5),
    onError            = PureBlack
)

data class AppExtendedColors(
    val bgCard: Color,
    val bgPanel: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val blueButton: Color,
    val blueButtonAlt: Color
)

private val LocalExtendedColors = staticCompositionLocalOf<AppExtendedColors> {
    // Valores por defecto (no usados en prod)
    AppExtendedColors(
        bgCard = PureWhite,
        bgPanel = PureWhite,
        textPrimary = PureBlack,
        textSecondary = PureBlack,
        blueButton = BlueButton,
        blueButtonAlt = OceanBlueButton
    )
}

private val LightExtended = AppExtendedColors(
    bgCard       = PureWhite,
    bgPanel      = BgGreenWhite,
    textPrimary  = LettersAndIcons,
    textSecondary= LettersAndIcons.copy(alpha = 0.75f),
    blueButton   = BlueButton,
    blueButtonAlt= OceanBlueButton
)

private val DarkExtended = AppExtendedColors(
    bgCard       = BgDarkAndLetters,   // #052224
    bgPanel      = DarkModeGreenBar,   // #0E3E3E
    textPrimary  = PureWhite,
    textSecondary= PureWhite.copy(alpha = 0.75f),
    blueButton   = BlueButton,
    blueButtonAlt= OceanBlueButton
)

object AppTheme {
    val colors: AppExtendedColors
        @Composable get() = LocalExtendedColors.current
}

// =====================
// Theme wrapper
// =====================

@Composable
fun TP3ParcialGrupo5Theme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}
