package com.ort.tp3parcialgrupo5.presentation.categories.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite

@Composable
fun CategoryButton(
    iconRes: Int,
    nameRes: Int,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .width(110.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(backgroundColor, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(iconRes),
                contentDescription = stringResource(nameRes),
                modifier = Modifier.size(48.dp)
            )
        }
        Text(
            text = stringResource(nameRes),
            color = FinWhite,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 12.sp
        )
    }
}
