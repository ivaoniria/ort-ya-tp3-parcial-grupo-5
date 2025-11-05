package com.ort.tp3parcialgrupo5.presentation.on_boarding.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite95

@Composable
fun OnboardingImageCircle(@DrawableRes drawableRes: Int) {
    Surface(color = FinWhite95, shape = CircleShape) {
        Image(
            painter = painterResource(id = drawableRes),
            contentDescription = null,
            modifier = Modifier.size(287.dp)
        )
    }
}
