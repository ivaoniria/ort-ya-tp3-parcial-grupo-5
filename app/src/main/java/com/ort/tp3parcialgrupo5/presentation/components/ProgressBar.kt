package com.ort.tp3parcialgrupo5.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.*

@Composable
fun ProgressBar(
    progressPercent: Int,
    goalAmount: String,
    modifier: Modifier = Modifier,
    width: Dp = 330.dp,
    height: Dp = 30.dp,
    backgroundColor: Color = DarkModeGreenBlack,
    trackColor: Color = AccountBalanceLabel,
    progressTextColor: Color = FinWhite,
    amountTextColor: Color = SummarySubtitleDark
) {
    val p = (progressPercent.coerceIn(0, 100)) / 100f

    Box(
        modifier = modifier
            .width(width)
            .height(height),
        contentAlignment = Alignment.CenterStart
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val r = size.height / 2f

            drawRoundRect(
                color = backgroundColor,
                cornerRadius = CornerRadius(r, r),
                size = size
            )

            val inset = 0.9f * density
            val innerSize = Size(
                width = size.width - inset * 2,
                height = size.height - inset * 2
            )
            val innerTopLeft = Offset(inset, inset)
            val innerRadius = (innerSize.height / 2f)

            drawRoundRect(
                color = trackColor,
                topLeft = innerTopLeft,
                size = innerSize,
                cornerRadius = CornerRadius(innerRadius, innerRadius)
            )

            drawRoundRect(
                color = DarkModeGreenBlack,
                topLeft = innerTopLeft,
                size = Size(width = innerSize.width * p, height = innerSize.height),
                cornerRadius = CornerRadius(innerRadius, innerRadius)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$progressPercent%",
                style = MaterialTheme.typography.bodyMedium,
                color = progressTextColor,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = goalAmount,
                style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic),
                color = amountTextColor,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF031314)
@Composable
private fun PreviewProgressBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(DarkModeGreenBlack)
    ) {
        ProgressBar(
            progressPercent = 30,
            goalAmount = stringResource(R.string.progress_bar)
        )
    }
}
