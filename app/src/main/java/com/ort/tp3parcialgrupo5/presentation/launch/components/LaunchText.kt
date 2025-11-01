package com.ort.tp3parcialgrupo5.presentation.launch.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.ui.theme.FinBrand
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite80
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite90

@Composable
fun LaunchText(text: String) {
    Text(
        text = text,
        color = FinBrand,
        fontSize = 40.sp,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 0.5.sp
    )
}

@Composable
fun LaunchTextSubtitleCenter(text: String) {
    Text(
        text = text,
        color = FinWhite80,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun LaunchTextLinkLight(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = FinWhite90,
        fontSize = 13.sp,
        modifier = modifier.clickable { onClick() }
    )
}