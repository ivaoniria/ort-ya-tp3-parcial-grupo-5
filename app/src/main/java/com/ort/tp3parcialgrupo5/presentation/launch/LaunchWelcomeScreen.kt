package com.ort.tp3parcialgrupo5.presentation.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.launch.components.LaunchButtons
import com.ort.tp3parcialgrupo5.presentation.launch.components.LaunchLayouts
import com.ort.tp3parcialgrupo5.presentation.launch.components.LaunchLayoutsCenteredColumn
import com.ort.tp3parcialgrupo5.presentation.launch.components.LaunchSecondaryButton
import com.ort.tp3parcialgrupo5.presentation.launch.components.LaunchText
import com.ort.tp3parcialgrupo5.presentation.launch.components.LaunchTextLinkLight
import com.ort.tp3parcialgrupo5.presentation.launch.components.LaunchTextSubtitleCenter
import com.ort.tp3parcialgrupo5.ui.theme.FinWiseTheme

@Composable
fun LaunchWelcomeScreen(
    onLogin: () -> Unit = {},
    onSignUp: () -> Unit = {},
    onForgot: () -> Unit = {}
) {
    LaunchLayouts {
        LaunchLayoutsCenteredColumn {
            Image(
                painter = painterResource(id = R.drawable.vector__1_),
                contentDescription = "Logo FinWise"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Título (marca)
            LaunchText(text = stringResource(id = R.string.brand_name))

            // Subtítulo
            LaunchTextSubtitleCenter(
                text = stringResource(id = R.string.welcome_subtitle)
            )

            LaunchButtons(
                text = stringResource(id = R.string.login),
                onClick = onLogin
            )

            LaunchSecondaryButton(
                text = stringResource(id = R.string.sign_up),
                onClick = onSignUp
            )

            LaunchTextLinkLight(
                text = stringResource(id = R.string.forgot_password),
                onClick = onForgot
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewLaunchWelcomeScreen() {
    FinWiseTheme {
        LaunchWelcomeScreen()
    }
}