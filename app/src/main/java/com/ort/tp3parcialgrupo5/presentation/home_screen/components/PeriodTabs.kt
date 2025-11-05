package com.ort.tp3parcialgrupo5.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.BackgroundBottomNav
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent
import com.ort.tp3parcialgrupo5.ui.theme.FinButtonText
import com.ort.tp3parcialgrupo5.ui.theme.White80

@Composable
fun PeriodTabs(
    modifier: Modifier = Modifier,
    onTabSelected: (String) -> Unit = {}
) {
    var selectedIndex by remember { mutableStateOf(2) }

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
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEachIndexed { i, txt ->
            val selected = i == selectedIndex
            if (selected) {
                Surface(
                    color = CyanAccent,
                    shape = RoundedCornerShape(24.dp),
                    shadowElevation = 4.dp,
                    modifier = Modifier
                        .clickable {
                            selectedIndex = i
                            onTabSelected(txt)
                        }
                ) {
                    Text(
                        text = txt,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = FinButtonText
                    )
                }
            } else {
                Text(
                    text = txt,
                    modifier = Modifier
                        .clickable {
                            selectedIndex = i
                            onTabSelected(txt)
                        }
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = White80
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
