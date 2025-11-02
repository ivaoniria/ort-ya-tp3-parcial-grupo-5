package com.ort.tp3parcialgrupo5.presentation.home_page.floating_menu.notification.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
fun NotificationHeader(title: String, onBack: (() -> Unit)? = null, onBell: (() -> Unit)? = null) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .background(Color.White.copy(alpha = 0.15f), CircleShape)
                .clickable(enabled = onBack != null) { onBack?.invoke() }
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.fechaback), contentDescription = null)
        }
        Text(
            text = title,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f).padding(top = 2.dp),
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .size(34.dp)
                .background(Color.White.copy(alpha = 0.15f), CircleShape)
                .clickable(enabled = onBell != null) { onBell?.invoke() }
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.bell), contentDescription = null)
        }
    }
}