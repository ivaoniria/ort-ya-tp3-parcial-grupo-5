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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components.PinEntryCircle
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components.SecurityPinButton
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components.SecurityPinFooter
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography

@Composable
fun SecurityPinScreen() {
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
                    color = Color.White
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
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(24.dp))


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        PinEntryCircle(number = 2)
                        PinEntryCircle(number = 7)
                        PinEntryCircle(number = 3)
                        PinEntryCircle(number = 9)
                        PinEntryCircle(number = 1)
                        PinEntryCircle(number = 6)
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    // Action Buttons
                    Column(modifier = Modifier.padding(horizontal = 40.dp)) {
                        SecurityPinButton(
                            text = stringResource(id = R.string.accept),
                            onClick = { /*TODO*/ },
                            backgroundColor = colorResource(id = R.color.main_green),
                            textColor = colorResource(id = R.color.letters_and_icons)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        SecurityPinButton(
                            text = stringResource(id = R.string.send_again),
                            onClick = { /*TODO*/ },
                            backgroundColor = colorResource(id = R.color.bg_green_white),
                            textColor = colorResource(id = R.color.letters_and_icons)
                        )
                    }

                    Spacer(modifier = Modifier.height(150.dp))

                    // Footer
                    SecurityPinFooter()

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