package com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.ui.theme.BackgroundMainContainer
import kotlinx.coroutines.delay

@Composable
fun PasswordChangedScreen(
    onFinish: () -> Unit = {}
) {
    LaunchedEffect(Unit) {
        delay(3000)
        onFinish()
    }

    BaseLayout(
        backgroundMainColor = BackgroundMainContainer,
        backgroundListColor = BackgroundMainContainer,
        contentTop = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 40.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.check_changed_progress),
                        contentDescription = null,
                        modifier = Modifier.size(120.dp)
                    )
                    Spacer(Modifier.height(24.dp))
                    Text(
                        text = stringResource(id = R.string.password_changed_success),
                        color = Color(0xFFE0F8D7),
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.widthIn(max = 220.dp)
                    )
                }
            }
        },
        contentBottom = { }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPasswordChangedScreen() {
    MaterialTheme {
        PasswordChangedScreen()
    }
}
