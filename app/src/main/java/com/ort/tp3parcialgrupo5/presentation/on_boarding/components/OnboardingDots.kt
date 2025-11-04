package com.ort.tp3parcialgrupo5.presentation.on_boarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite40

@Composable
fun OnboardingDots(page: Int, pages: Int) {
    Row {
        repeat(pages) { i ->
            Dot(selected = i == page)
            if (i < pages - 1) Spacer(Modifier.size(8.dp))
        }
    }
}

@Composable
private fun Dot(selected: Boolean) {
    Box(
        modifier = Modifier
            .size(if (selected) 8.dp else 6.dp)
            .background(
                color = if (selected) FinWhite else FinWhite40,
                shape = CircleShape
            )
    )
}