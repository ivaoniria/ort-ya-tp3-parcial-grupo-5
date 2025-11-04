package com.ort.tp3parcialgrupo5.presentation.transaction.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.PaddingValues
import com.ort.tp3parcialgrupo5.R

@Composable
fun BaseShapeBackground(
    baseShapeRes: Int = R.drawable.base_shape,
    panelColor: Color = Color(14, 62, 62),
    cornerRadiusDp: Dp = 28.dp,
    modifier: Modifier = Modifier,
    heightFraction: Float = 1f,
    heightMax: Dp? = null,
    mirrorHorizontally: Boolean = true,
    mirrorVertically: Boolean = false,
    yOffset: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 18.dp),
    content: @Composable ColumnScope.() -> Unit = {}
) {
    BoxWithConstraints(modifier) {
        val h = heightMax ?: (maxHeight * heightFraction.coerceIn(0.3f, 1f))
        Surface(
            color = panelColor,
            shape = RoundedCornerShape(topStart = cornerRadiusDp, topEnd = cornerRadiusDp),
            modifier = Modifier
                .fillMaxWidth()
                .height(h)
                .align(Alignment.BottomCenter)
        ) {
            Image(
                painter = painterResource(baseShapeRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(h)
                    .align(Alignment.BottomCenter)
                    .offset(y = yOffset)
                    .graphicsLayer(
                        scaleX = if (mirrorHorizontally) -1f else 1f,
                        scaleY = if (mirrorVertically) -1f else 1f
                    ),
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                content = content
            )
        }
    }
}