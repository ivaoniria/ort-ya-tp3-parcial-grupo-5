package com.ort.tp3parcialgrupo5.presentation.login_sign_up.forgot_reset_password

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.forgot_reset_password.components.ForgotPasswordButton
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.forgot_reset_password.components.ForgotPasswordFooter
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.forgot_reset_password.components.ForgotPasswordTextField
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite
import com.ort.tp3parcialgrupo5.ui.theme.TransactionSubtitleText

@Composable
fun ForgotResetPasswordScreen() {
    var email by remember { mutableStateOf("") }

    BaseLayout(
        contentTop = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp, bottom = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.forgot_password_title),
                    style = AppTypography.displaySmall,
                    color = FinWhite
                )
            }
        },
        contentBottom = {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp) 
                ) {
                    // --- Form Part ---
                    Text(
                        text = stringResource(id = R.string.reset_password_question),
                        style = AppTypography.titleLarge,
                        color = colorResource(id = R.color.main_green)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = R.string.reset_password_lorem_ipsum),
                        style = AppTypography.bodyMedium,
                        color = TransactionSubtitleText // CORRECTED: Used color from Theme
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    ForgotPasswordTextField(
                        label = stringResource(id = R.string.enter_email_address),
                        value = email,
                        onValueChange = { email = it },
                        placeholder = stringResource(id = R.string.placeholder_email)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Column(modifier = Modifier.padding(horizontal = 40.dp)) {
                        ForgotPasswordButton(
                            text = stringResource(id = R.string.next_step),
                            onClick = { /*TODO*/ },
                            backgroundColor = colorResource(id = R.color.main_green),
                            textColor = colorResource(id = R.color.letters_and_icons)
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    // --- Footer Part ---
                    ForgotPasswordFooter()

                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ForgotResetPasswordScreenPreview() {
    ForgotResetPasswordScreen()
}
