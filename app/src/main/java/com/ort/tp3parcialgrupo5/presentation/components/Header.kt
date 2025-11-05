package com.ort.tp3parcialgrupo5.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.TP3ParcialGrupo5Theme

@Composable
fun Header(
    title: String,
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null,
    bellIcon: Int = R.drawable.bell
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 15.dp, bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .background(Color.White.copy(alpha = 0.15f), CircleShape)
                .clickable(enabled = onBack != null) { onBack?.invoke() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.fechaback),
                contentDescription = "Back"
            )
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
                .then(
                    if (bellIcon != R.drawable.icon_notificationbellblue) {
                        Modifier.background(Color.White.copy(alpha = 0.15f), CircleShape)
                    } else {
                        Modifier
                    }
                )
                .clickable(enabled = onBell != null) { onBell?.invoke() }
                .then(
                    if (bellIcon != R.drawable.icon_notificationbellblue) {
                        Modifier.padding(8.dp)
                    } else {
                        Modifier
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(bellIcon),
                contentDescription = "Notifications",
                modifier = Modifier.size(34.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeaderPreview() {
    TP3ParcialGrupo5Theme {
        Surface(color = Color(0xFF101010)) {
            Header(
                title = "Profile",
                onBack = {},
                onBell = {}
            )
        }
    }
}

