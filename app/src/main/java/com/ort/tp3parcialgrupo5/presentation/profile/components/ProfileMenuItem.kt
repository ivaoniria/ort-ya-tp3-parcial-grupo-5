package com.ort.tp3parcialgrupo5.presentation.profile.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite

@Composable
fun ProfileMenuItem(
    @DrawableRes iconRes: Int,
    @StringRes textRes: Int,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick?.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = stringResource(id = textRes),
            tint = Color.Unspecified,
            modifier = Modifier.size(44.dp)
        )

        Spacer(Modifier.width(14.dp))

        Text(
            text = stringResource(id = textRes),
            fontSize = 14.sp,
            color = FinWhite
        )
    }
}