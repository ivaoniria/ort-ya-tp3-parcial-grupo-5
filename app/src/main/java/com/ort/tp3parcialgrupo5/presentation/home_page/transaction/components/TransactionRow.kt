package com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
fun TransactionRow(
    title: String,
    subtitle: String,
    category: String,
    amount: String,
    positive: Boolean,
    iconRes: Int
) {
    val amountColor = if (positive) Color.White else Color(0xFF11A3FF)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .background(Color.White.copy(alpha = 0.15f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(subtitle, color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
        }

        Box(Modifier.height(22.dp).width(1.dp).background(Color.White.copy(alpha = 0.25f)))

        Spacer(Modifier.width(12.dp))

        Column(horizontalAlignment = Alignment.End) {
            Text(category, color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
            Text(amount, color = amountColor, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}