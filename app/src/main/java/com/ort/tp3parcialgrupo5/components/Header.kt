package com.ort.tp3parcialgrupo5.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R

@Composable
fun Header(
    title: String,
    modifier: Modifier = Modifier,
    showBackButton: Boolean = true,
    showBellButton: Boolean = true,
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null,
    titleSize: Int = 20,
    backgroundColor: Color = Color.White.copy(alpha = 0.15f),
    titleColor: Color = Color.White
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Back button
        if (showBackButton) {
            Image(
                painter = painterResource(R.drawable.fechaback),
                contentDescription = "Back",
                modifier = Modifier
                    .size(34.dp)
                    .clickable(enabled = onBack != null) { onBack?.invoke() }
            )
        } else {
            Spacer(Modifier.size(34.dp))
        }

        // Title
        Text(
            text = title,
            color = titleColor,
            fontSize = titleSize.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f).padding(top = 2.dp),
            textAlign = TextAlign.Center
        )

        // Bell button
        if (showBellButton) {
            Image(
                painter = painterResource(R.drawable.bell),
                contentDescription = "Notifications",
                modifier = Modifier
                    .size(34.dp)
                    .clickable(enabled = onBell != null) { onBell?.invoke() }
            )
        } else {
            Spacer(Modifier.size(34.dp))
        }
    }
}

