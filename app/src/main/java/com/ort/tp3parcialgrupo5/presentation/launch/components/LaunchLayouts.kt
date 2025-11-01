package com.ort.tp3parcialgrupo5.presentation.launch.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.ui.theme.FinBg

@Composable
fun LaunchLayouts(
    modifier: Modifier = Modifier,
    backgroundColor: Color = FinBg,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun LaunchLayoutsCenteredColumn(
    verticalSpacingDp: Int = 18,
    content: @Composable () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(verticalSpacingDp.dp)
    ) {
        content()
    }
}
