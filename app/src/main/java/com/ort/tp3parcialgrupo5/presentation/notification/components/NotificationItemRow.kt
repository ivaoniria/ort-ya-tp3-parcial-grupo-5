package com.ort.tp3parcialgrupo5.presentation.notification.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val IconBackgroundColor = Color(0xFF00D09E)
private val AccentColor = Color(0xFF00D09E)

@Composable
fun NotificationItemRow(
    iconRes: Int,
    title: String,
    body: String,
    rightTime: String,
    bottomAccent: String? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(
                        color = IconBackgroundColor,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = body,
                    color = Color.White.copy(alpha = 0.75f),
                    fontSize = 12.sp
                )

                if (!bottomAccent.isNullOrBlank()) {
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = bottomAccent,
                        color = AccentColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(Modifier.width(12.dp))

            Text(
                text = rightTime,
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 12.sp
            )
        }

        Spacer(Modifier.height(14.dp))

        HorizontalDivider(
            color = Color.White.copy(alpha = 0.20f),
            thickness = 1.dp
        )
    }
}