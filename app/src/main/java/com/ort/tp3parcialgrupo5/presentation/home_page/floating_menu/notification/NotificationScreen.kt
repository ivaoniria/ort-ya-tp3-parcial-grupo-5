package com.ort.tp3parcialgrupo5.presentation.home_page.floating_menu.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.components.Header

@Composable
fun NotificationScreen(
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null
) {
    val BgDark = Color(5, 34, 36)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgDark)
            .statusBarsPadding()
            .padding(20.dp)
    ) {
        Header(
            title = "Notifications",
            onBack = onBack,
            onBell = onBell,
            showBellButton = false
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Notifications Screen\n(En construcción)",
                color = Color.White
            )
        }
    }
}


