package com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components.LoginButton
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components.LoginFooter
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components.LoginTextField
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components.LoginTitle
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.bg_dark_green_black))
    ) {
        LoginTitle()

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.card_dark_green))
        ) {
            Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)) {
                LoginTextField(
                    label = stringResource(id = R.string.username_or_email),
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "example@example.com",
                    isPassword = false
                )
                Spacer(modifier = Modifier.height(16.dp))
                LoginTextField(
                    label = stringResource(id = R.string.password),
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "........",
                    isPassword = true
                )
                Spacer(modifier = Modifier.height(24.dp))
                LoginButton(
                    text = stringResource(id = R.string.log_in),
                    onClick = { /*TODO*/ },
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
                    onClick = { /*TODO*/ },
                    backgroundColor = colorResource(id = R.color.bg_green_white),
                    textColor = colorResource(id = R.color.letters_and_icons)
                )
                Spacer(modifier = Modifier.height(16.dp))
                LoginFooter()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen()
}
