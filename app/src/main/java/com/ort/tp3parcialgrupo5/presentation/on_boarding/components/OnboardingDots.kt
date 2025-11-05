package com.ort.tp3parcialgrupo5.presentation.on_boarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val LightGreen = Color(0xFFDFF7E2)

@Composable
fun OnboardingDots(page: Int, pages: Int) {
    Row {
        repeat(pages) { i ->
            val selected = i == page
            Box(
                modifier = Modifier
                    .size(13.dp)
                    .border(2.dp, LightGreen, CircleShape)
                    .background(if (selected) LightGreen else Color.Transparent, CircleShape)
            )
            if (i < pages - 1) Spacer(Modifier.size(10.dp))
        }
    }
}
