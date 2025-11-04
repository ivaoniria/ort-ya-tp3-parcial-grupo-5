package com.ort.tp3parcialgrupo5.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.BackgroundBottomNav
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent

@Composable
fun PeriodTabs(modifier: Modifier = Modifier) {
    val selectedIndex = 2
    val tabs = listOf(
        stringResource(R.string.daily),
        stringResource(R.string.weekly),
        stringResource(R.string.monthly)
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(BackgroundBottomNav, shape = RoundedCornerShape(22.dp))
            .padding(top = 6.dp, end = 14.dp, bottom = 6.dp, start = 14.dp),
        Arrangement.SpaceAround,
        Alignment.CenterVertically
    ) {
        tabs.forEachIndexed { i, txt ->
            val selected = i == selectedIndex
            if (selected) {
                Surface(
                    color = CyanAccent,
                    shape = RoundedCornerShape(24.dp),
                    shadowElevation = 4.dp,
                    onClick = { },
                    modifier = Modifier
                ) {
                    Text(
                        text = txt,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                }
            } else {
                Text(
                    text = txt,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.85f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPeriodTabs() {
    MaterialTheme {
        PeriodTabs()
    }
}
