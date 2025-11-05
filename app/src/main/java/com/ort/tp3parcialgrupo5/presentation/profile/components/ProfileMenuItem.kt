// com/ort/tp3parcialgrupo5/presentation/profile/components/ProfileMenuItem.kt
package com.ort.tp3parcialgrupo5.presentation.profile.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent
import com.ort.tp3parcialgrupo5.ui.theme.UnspecifiedColor

@Composable
fun ProfileMenuItem(
    @DrawableRes iconRes: Int,
    @StringRes textRes: Int,
    modifier: Modifier = Modifier,
    iconWidth: Dp = 57.dp,
    iconHeight: Dp = 53.dp,
    gapIconText: Dp = 34.dp,
    minRowHeight: Dp = 64.dp,
    onClick: () -> Unit = {}
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()

    val pressBg = if (pressed) CyanAccent.copy(alpha = 0.20f) else Color.Transparent
    val pressText = if (pressed) CyanAccent else MaterialTheme.colorScheme.onBackground

    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = minRowHeight)
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(pressBg)
            .clickable(
                interactionSource = interaction,
                indication = null
            ) { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = stringResource(id = textRes),
            modifier = Modifier.size(iconWidth, iconHeight),
            tint = UnspecifiedColor
        )
        Spacer(Modifier.width(gapIconText))
        Text(
            text = stringResource(id = textRes),
            style = MaterialTheme.typography.bodyLarge,
            color = pressText
        )
    }
}
