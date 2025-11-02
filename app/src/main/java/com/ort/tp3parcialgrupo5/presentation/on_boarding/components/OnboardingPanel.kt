package com.ort.tp3parcialgrupo5.presentation.on_boarding.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.ui.theme.FinPanel

@Composable
fun OnboardingPanel(
    @DrawableRes bgDrawableRes: Int? = null,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.78f),
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
            .background(FinPanel),
        contentAlignment = Alignment.Center
    ) {
        if (bgDrawableRes != null) {
            Image(
                painter = painterResource(bgDrawableRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
        }
        content()
    }
}