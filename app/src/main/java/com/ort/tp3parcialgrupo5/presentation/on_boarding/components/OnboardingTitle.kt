package com.ort.tp3parcialgrupo5.presentation.on_boarding.components


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite

@Composable
fun OnboardingTitle(text: String) {
    Text(
        text = text,
        color = FinWhite,
        fontSize = 26.sp,
        fontWeight = FontWeight.ExtraBold,
        textAlign = TextAlign.Center,
        lineHeight = 32.sp
    )
}