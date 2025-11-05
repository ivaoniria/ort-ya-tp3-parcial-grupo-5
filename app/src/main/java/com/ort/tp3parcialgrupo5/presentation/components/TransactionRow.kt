package com.ort.tp3parcialgrupo5.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite
import com.ort.tp3parcialgrupo5.ui.theme.Hermo
import com.ort.tp3parcialgrupo5.ui.theme.Hermosho
import com.ort.tp3parcialgrupo5.ui.theme.HermoshoColor
import com.ort.tp3parcialgrupo5.ui.theme.Transparent

@Composable
fun TransactionRow(
    iconRes: Int,
    title: String,
    subtitle: String,
    category: String,
    amount: String,
    amountColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val pressBg = if (pressed) Hermo else Transparent

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(pressBg)
            .clickable(
                interactionSource = interaction,
                indication = null
            ) { onClick() }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(56.dp),
            tint = Color.Unspecified
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = FinWhite
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = Hermosho
            )
        }

        Box(
            modifier = Modifier
                .height(40.dp)
                .width(1.dp)
                .background(HermoshoColor)
        )

        Box(
            modifier = Modifier.width(51.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Light,
                color = Color.White.copy(alpha = 0.8f)
            )
        }

        Box(
            modifier = Modifier
                .height(40.dp)
                .width(1.dp)
                .background(Color(0xFF1ECED5))
        )

        Text(
            text = amount,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = amountColor,
            modifier = Modifier.widthIn(min = 85.dp)
        )
    }
}
