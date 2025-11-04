package com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    onBell: (() -> Unit)? = null
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(bottom = 40.dp, start = 15.dp, end = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Text(
                text = stringResource(R.string.hi_welcome_back),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 20.sp,
                    lineHeight = 22.sp
                ),
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Text(
                text = stringResource(R.string.good_morning),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Default
                ),
                color = Color.White.copy(alpha = 0.7f)
            )
        }

        IconButton(onClick = { onBell?.invoke() }) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE6F0EB)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = stringResource(R.string.notifications),
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            }
        }
    }
}
