package com.ort.tp3parcialgrupo5.presentation.home_page.floating_menu.notification.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotificationItemRow(
    iconRes: Int,
    title: String,
    body: String,
    rightTime: String,
    bottomAccent: String? = null,
    bottomAccentColor: Color = Color(0xFF00D09E)
) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(44.dp).background(Color.White.copy(alpha = 0.15f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(iconRes), contentDescription = null, modifier = Modifier.size(22.dp))
            }
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(body, color = Color.White.copy(alpha = 0.75f), fontSize = 12.sp)
                if (!bottomAccent.isNullOrBlank()) {
                    Text(bottomAccent, color = bottomAccentColor, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }
            }
            Spacer(Modifier.width(12.dp))
            Text(rightTime, color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
        }
        Spacer(Modifier.height(14.dp))
        Divider(color = Color.White.copy(alpha = 0.20f), thickness = 1.dp)
    }
}