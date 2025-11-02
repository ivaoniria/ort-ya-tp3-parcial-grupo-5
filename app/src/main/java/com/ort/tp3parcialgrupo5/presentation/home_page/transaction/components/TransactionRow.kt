package com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(56.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = Color(0xFF5BA3D0)
            )
        }

        Box(
            modifier = Modifier
                .height(40.dp)
                .width(1.dp)
                .background(Color(0xFF1ECED5))
        )

        Text(
            text = category,
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.8f),
            modifier = Modifier.widthIn(min = 60.dp)
        )

        Box(
            modifier = Modifier
                .height(40.dp)
                .width(1.dp)
                .background(Color(0xFF1ECED5))
        )

        Text(
            text = amount,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = amountColor,
            modifier = Modifier.widthIn(min = 85.dp)
        )
    }
}

