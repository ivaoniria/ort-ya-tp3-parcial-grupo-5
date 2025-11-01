package com.ort.tp3parcialgrupo5.presentation.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.launch.components.LaunchLayouts
import com.ort.tp3parcialgrupo5.ui.theme.FinWiseTheme
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite
import com.ort.tp3parcialgrupo5.ui.theme.FinBrand
import kotlinx.coroutines.delay

private const val SplashDurationMs = 1500L

@Composable
fun LaunchInitialScreen(
    onFinished: () -> Unit = {}
) {
    LaunchedEffect(Unit) {
        delay(SplashDurationMs)
        onFinished()
    }

    LaunchLayouts(backgroundColor = FinBrand) {
        Box(
            modifier = Modifier.padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Logo FinWise"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.brand_name),
                    color = FinWhite,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewLaunchInitialScreen() {
    FinWiseTheme {
        LaunchInitialScreen()
    }
}