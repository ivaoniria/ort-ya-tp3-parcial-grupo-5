package com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components.AuthScreenHeader
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components.AuthPasswordField
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components.PrimaryRoundedButton

@Composable
fun NewPasswordScreen(
    onPasswordChanged: (() -> Unit)? = null
) {
    val newPass = remember { mutableStateOf("") }
    val confirmPass = remember { mutableStateOf("") }

    BaseLayout(
        contentTop = {
            AuthScreenHeader(titleRes = R.string.new_password_title)
            Spacer(Modifier.height(24.dp))
        },
        contentBottom = {
            item {
                AuthPasswordField(
                    labelRes = R.string.new_password_label,
                    value = newPass.value,
                    onValueChange = { newPass.value = it }
                )
            }
            item { Spacer(Modifier.height(16.dp)) }
            item {
                AuthPasswordField(
                    labelRes = R.string.confirm_new_password_label,
                    value = confirmPass.value,
                    onValueChange = { confirmPass.value = it }
                )
            }
            item { Spacer(Modifier.height(40.dp)) }
            item {
                PrimaryRoundedButton(
                    textRes = R.string.change_password_button,
                    enabled = newPass.value.isNotEmpty() && confirmPass.value.isNotEmpty()
                ) {
                    onPasswordChanged?.invoke()
                }
            }
            item { Spacer(Modifier.height(90.dp)) }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewNewPasswordScreen() {
    MaterialTheme {
        NewPasswordScreen()
    }
}
