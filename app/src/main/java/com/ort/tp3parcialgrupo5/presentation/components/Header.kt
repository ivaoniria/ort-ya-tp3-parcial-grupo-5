package com.ort.tp3parcialgrupo5.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.BlueButton
import com.ort.tp3parcialgrupo5.ui.theme.HeaderBellBackground

@Composable
fun Header(
    title: String? = null,
    welcomeTitle: String? = null,
    welcomeSubtitle: String? = null,
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null,
    isNotification: Boolean = false,
    paddingStartDp: Dp = 0.dp,
    paddingEndDp: Dp = 0.dp,
    paddingTopDp: Dp = 0.dp,
    headerYOffsetDp: Dp = (-12).dp
) {
    val baseHeight = 56.dp
    val sideTouchSize = 52.dp
    val iconContainerSize = 36.dp
    val bellBgColor = if (isNotification) BlueButton else HeaderBellBackground

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = headerYOffsetDp)
            .padding(start = paddingStartDp, end = paddingEndDp, top = paddingTopDp)
            .height(baseHeight),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (welcomeTitle == null) {
            Box(
                modifier = Modifier
                    .offset(x = (-10).dp)
                    .size(sideTouchSize)
                    .clickable(enabled = onBack != null) { onBack?.invoke() },
                contentAlignment = Alignment.Center
            ) {
                if (onBack != null) {
                    Image(
                        painter = painterResource(R.drawable.fechaback),
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            Box(modifier = Modifier.width(8.dp))
        }

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = if (welcomeTitle != null) Alignment.CenterStart else Alignment.Center
        ) {
            if (welcomeTitle != null) {
                androidx.compose.foundation.layout.Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.offset(x = (-4).dp, y = 6.dp)
                ) {
                    Text(
                        text = welcomeTitle,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start
                    )
                    if (welcomeSubtitle != null) {
                        Text(
                            text = welcomeSubtitle,
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                }
            } else if (title != null) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }

        Box(
            modifier = Modifier
                .offset(x = 10.dp)
                .size(sideTouchSize)
                .clickable(enabled = onBell != null) { onBell?.invoke() },
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(iconContainerSize)
                    .background(bellBgColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.bell),
                    contentDescription = "Notifications"
                )
            }
        }
    }
}
