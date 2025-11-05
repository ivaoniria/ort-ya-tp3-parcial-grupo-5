package com.ort.tp3parcialgrupo5.ui.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// Tokens de radio (ajustá a gusto)
object Radii {
    val none    = 0.dp
    val xs      = 8.dp
    val sm      = 12.dp
    val md      = 16.dp
    val lg      = 20.dp
    val xl      = 24.dp
    val xxl     = 28.dp
    val xxxl    = 32.dp
    val huge    = 40.dp
}

// Shapes base de Material 3 (para Buttons, Card, Dialog, etc.)
val AppShapes = Shapes(
    // chips / pequeños
    small  = RoundedCornerShape(Radii.sm),
    // cards y contenedores intermedios
    medium = RoundedCornerShape(Radii.lg),
    // contenedores grandes
    large  = RoundedCornerShape(Radii.xxl)
)

// Helpers semánticos para tu diseño
object AppShape {
    val Pill: CornerBasedShape = RoundedCornerShape(50)
    val Chip: CornerBasedShape = RoundedCornerShape(Radii.xl)
    val Card: CornerBasedShape = RoundedCornerShape(Radii.lg)
    val TopPanel: CornerBasedShape = RoundedCornerShape(
        topStart = Radii.xxxl,
        topEnd   = Radii.xxxl,
        bottomStart = Radii.none,
        bottomEnd   = Radii.none
    )

    val BottomPanel: CornerBasedShape = RoundedCornerShape(
        topStart = Radii.none,
        topEnd   = Radii.none,
        bottomStart = Radii.xxxl,
        bottomEnd   = Radii.xxxl
    )

    val Section: CornerBasedShape = RoundedCornerShape(Radii.xl)
}
