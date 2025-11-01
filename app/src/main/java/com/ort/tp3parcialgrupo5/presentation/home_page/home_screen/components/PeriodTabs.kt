package com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent
import com.ort.tp3parcialgrupo5.ui.theme.SurfaceVariantDark

@Composable
fun PeriodTabs(modifier: Modifier = Modifier) {
    val selectedIndex = 2
    val tabs = listOf("Daily", "Weekly", "Monthly")
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        tabs.forEachIndexed { i, txt ->
            val selected = i == selectedIndex
            Surface(
                color = if (selected) CyanAccent else SurfaceVariantDark,
                shape = RoundedCornerShape(24.dp),
                shadowElevation = if (selected) 4.dp else 0.dp,
                onClick = { },
                modifier = Modifier.padding(horizontal = 5.dp)
            ) {
                Text(
                    text = txt,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (selected) Color.White else Color.White.copy(alpha = 0.85f)
                )
            }
        }
    }
}
