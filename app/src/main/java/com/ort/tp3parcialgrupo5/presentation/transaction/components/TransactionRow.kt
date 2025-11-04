package com.ort.tp3parcialgrupo5.presentation.transaction.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
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
    val dividerColor = Color(0xFF00D09E)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(56.dp),
            tint = Color.Unspecified
        )

        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(subtitle, color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
        }

        Box(Modifier.height(40.dp).width(1.dp).background(dividerColor))

        Box(
            modifier = Modifier.width(51.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = category,
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
        }

        Box(Modifier.height(40.dp).width(1.dp).background(dividerColor))

        Text(
            text = amount,
            color = amountColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.widthIn(min = 80.dp)
        )
    }
}