package com.ort.tp3parcialgrupo5.presentation.notification.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val HeaderTextColor = Color.White
private val HeaderFontSize = 18.sp
private val HeaderFontWeight = FontWeight.SemiBold

@Composable
fun NotificationSectionHeader(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = HeaderTextColor,
        fontSize = HeaderFontSize,
        fontWeight = HeaderFontWeight,
        modifier = modifier
    )
}