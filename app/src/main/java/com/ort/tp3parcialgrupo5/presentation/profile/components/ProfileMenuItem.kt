// com/ort/tp3parcialgrupo5/presentation/profile/components/ProfileMenuItem.kt
package com.ort.tp3parcialgrupo5.presentation.profile.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProfileMenuItem(
    @DrawableRes iconRes: Int,
    @StringRes textRes: Int,
    modifier: Modifier = Modifier,
    iconWidth: Dp = 57.dp,
    iconHeight: Dp = 53.dp,
    gapIconText: Dp = 34.dp,
    minRowHeight: Dp = 64.dp,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = minRowHeight)
            .padding(horizontal = 24.dp)
            .let { m -> if (onClick != null) m.clickable { onClick() } else m },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = stringResource(id = textRes),
            modifier = Modifier.size(iconWidth, iconHeight),
            tint = androidx.compose.ui.graphics.Color.Unspecified
        )
        Spacer(Modifier.width(gapIconText))
        Text(
            text = stringResource(id = textRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
