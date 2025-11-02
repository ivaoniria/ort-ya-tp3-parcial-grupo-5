package com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavBar(
    selectedIndex: Int,
    highlightColor: Color,
    onSelect: (Int) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(5) { idx ->
            val isSelected = idx == selectedIndex
            val bg = when {
                isSelected -> highlightColor
                idx == 0 || idx == 4 -> Color.White.copy(alpha = 0.15f)
                else -> Color.White.copy(alpha = 0.12f)
            }
            Box(
                modifier = Modifier
                    .size(if (isSelected) 44.dp else 40.dp)
                    .background(bg, CircleShape)
                    .clickable { onSelect(idx) }
            )
        }
    }
}