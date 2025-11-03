package com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components.CreateAccountScreen
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components.LoginButton
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components.LoginTextField
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography

@Composable
fun CreateAccountScreen() {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.bg_dark_green_black)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = stringResource(id = R.string.create_account),
            style = AppTypography.displaySmall,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp)
                .padding(horizontal = 30.dp),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.card_dark_green))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                LoginTextField(
                    label = stringResource(id = R.string.full_name),
                    value = fullName,
                    onValueChange = { fullName = it },
                    placeholder = "example@example.com",
                    isPassword = false
                )
                Spacer(modifier = Modifier.height(16.dp))
                LoginTextField(
                    label = stringResource(id = R.string.email),
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "example@example.com",
                    isPassword = false
                )
                Spacer(modifier = Modifier.height(16.dp))
                LoginTextField(
                    label = stringResource(id = R.string.mobile_number),
                    value = mobileNumber,
                    onValueChange = { mobileNumber = it },
                    placeholder = "+ 123 456 789",
                    isPassword = false
                )
                Spacer(modifier = Modifier.height(16.dp))
                LoginTextField(
                    label = stringResource(id = R.string.date_of_birth),
                    value = dateOfBirth,
                    onValueChange = { dateOfBirth = it },
                    placeholder = "DD / MM / YYY",
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
                Spacer(modifier = Modifier.height(16.dp))
                LoginTextField(
                    label = stringResource(id = R.string.confirm_password),
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = "........",
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(24.dp))

                val termsAndPolicyString = buildAnnotatedString {
                    append(stringResource(id = R.string.by_continuing_you_agree) + " ")
                    withStyle(style = SpanStyle(color = colorResource(id = R.color.main_green))) {
                        append(stringResource(id = R.string.terms_of_use))
                    }
                    append(" and ")
                    withStyle(style = SpanStyle(color = colorResource(id = R.color.main_green))) {
                        append(stringResource(id = R.string.privacy_policy))
                    }
                }
                Text(
                    text = termsAndPolicyString,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                LoginButton(
                    text = stringResource(id = R.string.sign_up),
                    onClick = { /*TODO*/ },
                    backgroundColor = colorResource(id = R.color.main_green),
                    textColor = colorResource(id = R.color.letters_and_icons)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = stringResource(id = R.string.already_have_an_account), color = Color.Gray)
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(id = R.string.log_in), color = colorResource(id = R.color.main_green))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAccountScreenPreview() {
    CreateAccountScreen()
}
