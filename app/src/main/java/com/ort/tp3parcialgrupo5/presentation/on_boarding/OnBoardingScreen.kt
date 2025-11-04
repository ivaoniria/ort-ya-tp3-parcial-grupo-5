package com.ort.tp3parcialgrupo5.presentation.on_boarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.launch.components.LaunchLayoutsFullBleed
import com.ort.tp3parcialgrupo5.presentation.on_boarding.components.OnboardingDots
import com.ort.tp3parcialgrupo5.presentation.on_boarding.components.OnboardingImageCircle
import com.ort.tp3parcialgrupo5.presentation.on_boarding.components.OnboardingPanel
import com.ort.tp3parcialgrupo5.presentation.on_boarding.components.OnboardingTitle
import com.ort.tp3parcialgrupo5.ui.theme.FinWiseTheme

// Perillas de layout
private val TitleTopOffset = 64.dp
private val TitlePanelGap  = 24.dp
private val PanelBottomGap = 0.dp

data class OnbPage(@StringRes val titleRes: Int, @DrawableRes val imageRes: Int)

private val onbPages = listOf(
    OnbPage(R.string.onb_title_1, R.drawable.dinero_mano),
    OnbPage(R.string.onb_title_2, R.drawable.telefonoclick)
)

@Composable
fun OnboardingScreen(
    loginType: String = "login", // "login" o "signup"
    onFinish: () -> Unit = {}
) {
    var page by remember { mutableStateOf(0) }
    var dragAccum by remember { mutableStateOf(0f) }

    val swipeModifier = Modifier.pointerInput(page) {
        detectDragGestures(
            onDragEnd = {
                val threshold = 80f
                when {
                    dragAccum <= -threshold && page < onbPages.lastIndex -> page += 1
                    dragAccum >=  threshold && page > 0 -> page -= 1
                }
                dragAccum = 0f
            },
            onDrag = { _, dragAmount -> dragAccum += dragAmount.x }
        )
    }

    val current = onbPages[page]

    LaunchLayoutsFullBleed(modifier = swipeModifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = TitleTopOffset, bottom = PanelBottomGap),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.padding(horizontal = 24.dp)) {
                OnboardingTitle(text = stringResource(current.titleRes))
            }

            Spacer(Modifier.height(TitlePanelGap))

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                OnboardingPanel(
                    bgDrawableRes = R.drawable.base_shape,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .fillMaxHeight(0.78f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp, vertical = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OnboardingImageCircle(drawableRes = current.imageRes)

                        Spacer(Modifier.weight(1f))

                        Button(
                            onClick = {
                                if (page < onbPages.lastIndex) {
                                    page += 1
                                } else {
                                    onFinish()
                                }
                            },
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(28.dp),
                            modifier = Modifier
                                .fillMaxWidth(0.55f)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.Black.copy(alpha = 0.85f)
                            )
                        ) {
                            Text(
                                text = if (page < onbPages.lastIndex)
                                    stringResource(R.string.next)
                                else
                                    stringResource(R.string.get_started)
                            )
                        }

                        Spacer(Modifier.height(12.dp))
                        OnboardingDots(page = page, pages = onbPages.size)
                        Spacer(Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewOnboardingScreen() {
    FinWiseTheme { OnboardingScreen() }
}