package com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.components.LoginButton
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.components.LoginFooter
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.components.LoginTextField
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.components.LoginTitle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    BaseLayout(
        contentTop = {
            LoginTitle()
        },
        contentBottom = {
            item {
                Column {
                    LoginTextField(
                        label = stringResource(id = R.string.username_or_email),
                        value = email,
                        onValueChange = { email = it },
                        placeholder = stringResource(id = R.string.placeholder_email),
                        isPassword = false
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LoginTextField(
                        label = stringResource(id = R.string.password),
                        value = password,
                        onValueChange = { password = it },
                        placeholder = stringResource(id = R.string.placeholder_password),
                        isPassword = true
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    LoginButton(
                        text = stringResource(id = R.string.log_in),
                        onClick = { onLoginSuccess() },
                        backgroundColor = colorResource(id = R.color.main_green),
                        textColor = colorResource(id = R.color.letters_and_icons)
                    )
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(
                                text = stringResource(id = R.string.forgot_password),
                                color = Color.White,
                                style = AppTypography.bodyLarge
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    LoginButton(
                        text = stringResource(id = R.string.sign_up),
                        onClick = { onSignUpClick() },
                        backgroundColor = colorResource(id = R.color.bg_green_white),
                        textColor = colorResource(id = R.color.letters_and_icons)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LoginFooter()
                }
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen()
    }
}

