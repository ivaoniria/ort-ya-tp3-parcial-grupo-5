package com.ort.tp3parcialgrupo5.presentation.on_boarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.on_boarding.components.OnboardingDots
import com.ort.tp3parcialgrupo5.presentation.on_boarding.components.OnboardingImageCircle
import com.ort.tp3parcialgrupo5.presentation.on_boarding.components.OnboardingTitle
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite
import com.ort.tp3parcialgrupo5.ui.theme.FinWiseTheme

private val HorizontalPadding = 24.dp

data class OnbPage(@StringRes val titleRes: Int, @DrawableRes val imageRes: Int)

private val onbPages = listOf(
    OnbPage(R.string.onb_title_1, R.drawable.dinero_mano),
    OnbPage(R.string.onb_title_2, R.drawable.telefonoclick)
)

@Composable
fun OnboardingScreen(onFinish: () -> Unit = {}) {
    var page by remember { mutableStateOf(0) }
    var dragAccum by remember { mutableStateOf(0f) }

    val swipeModifier = Modifier.pointerInput(page) {
        detectDragGestures(
            onDragEnd = {
                val threshold = 80f
                when {
                    dragAccum <= -threshold && page < onbPages.lastIndex -> page += 1
                    dragAccum >= threshold && page > 0 -> page -= 1
                }
                dragAccum = 0f
            },
            onDrag = { _, dragAmount -> dragAccum += dragAmount.x }
        )
    }

    val current = onbPages[page]

    BaseLayout(
        listContainerModifier = swipeModifier.fillMaxSize(),
        contentTop = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f)
                    .padding(horizontal = HorizontalPadding),
                contentAlignment = Alignment.Center
            ) {
                OnboardingTitle(text = stringResource(current.titleRes))
            }
            Spacer(Modifier.height(45.dp))
        },
        contentBottom = {
            item {
                Spacer(Modifier.height(60.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = HorizontalPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    OnboardingImageCircle(drawableRes = current.imageRes)
                    Spacer(Modifier.height(40.dp))
                    TextButton(
                        onClick = {
                            if (page < onbPages.lastIndex) page += 1 else onFinish()
                        },
                        colors = ButtonDefaults.textButtonColors(contentColor = FinWhite)
                    ) {
                        Text(
                            text = if (page < onbPages.lastIndex) stringResource(R.string.next) else stringResource(R.string.get_started),
                            fontSize = 30.sp,
                            lineHeight = 22.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(Modifier.height(20.dp))
                    OnboardingDots(page = page, pages = onbPages.size)
                    Spacer(Modifier.height(32.dp))
                }
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewOnboardingScreen() {
    FinWiseTheme { OnboardingScreen() }
}
