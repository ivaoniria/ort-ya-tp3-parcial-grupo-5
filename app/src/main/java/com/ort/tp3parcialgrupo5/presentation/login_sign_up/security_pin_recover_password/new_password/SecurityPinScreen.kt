package com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components.PinEntryCircle
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components.SecurityPinButton
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components.SecurityPinFooter
import com.ort.tp3parcialgrupo5.ui.theme.AccountBalanceLabel
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography
import com.ort.tp3parcialgrupo5.ui.theme.FinBrand
import com.ort.tp3parcialgrupo5.ui.theme.FinBtnText
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite
import kotlin.random.Random

@Composable
fun SecurityPinScreen(
    onAccept: () -> Unit = {},
    onSignUp: () -> Unit = {}
) {
    var pinNumbers by remember { mutableStateOf(List(6) { Random.nextInt(0, 10) }) }

    BaseLayout(
        contentTop = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp, bottom = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.security_pin_title),
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
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.enter_security_pin),
                        style = AppTypography.titleMedium,
                        color = FinWhite
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        pinNumbers.forEach { num ->
                            PinEntryCircle(number = num)
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Column(modifier = Modifier.padding(horizontal = 40.dp)) {
                        SecurityPinButton(
                            text = stringResource(id = R.string.accept),
                            onClick = { onAccept() },
                            backgroundColor = FinBrand,
                            textColor = FinBtnText
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        SecurityPinButton(
                            text = stringResource(id = R.string.send_again),
                            onClick = { pinNumbers = List(6) { Random.nextInt(0, 10) } },
                            backgroundColor = AccountBalanceLabel,
                            textColor = FinBtnText
                        )
                    }
                    Spacer(modifier = Modifier.height(150.dp))
                    SecurityPinFooter(onSignUp = onSignUp)
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SecurityPinScreenPreview() {
    SecurityPinScreen()
}
