package com.ort.tp3parcialgrupo5.presentation.notification.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite40
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite80
import com.ort.tp3parcialgrupo5.ui.theme.Hermo
import com.ort.tp3parcialgrupo5.ui.theme.Hermosho
import com.ort.tp3parcialgrupo5.ui.theme.NotificationAccent
import com.ort.tp3parcialgrupo5.ui.theme.NotificationIconBg
import com.ort.tp3parcialgrupo5.ui.theme.Transparent

@Composable
fun NotificationItemRow(
    iconRes: Int,
    title: String,
    body: String,
    rightTime: String,
    bottomAccent: String? = null,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val rowBg = if (pressed) Hermo else Transparent
    val iconBg = if (pressed) NotificationIconBg.copy(alpha = 0.85f) else NotificationIconBg
    val rightTimeColor = FinWhite80

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(rowBg)
            .clickable(
                interactionSource = interaction,
                indication = null
            ) { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(
                        color = iconBg,
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
                    color = FinWhite,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = body,
                    color = Hermosho,
                    fontSize = 12.sp
                )
                if (!bottomAccent.isNullOrBlank()) {
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = bottomAccent,
                        color = NotificationAccent,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(Modifier.width(12.dp))

            Text(
                text = rightTime,
                color = rightTimeColor,
                fontSize = 12.sp
            )
        }

        Spacer(Modifier.height(14.dp))

        HorizontalDivider(
            color = FinWhite40,
            thickness = 1.dp
        )
    }
}
