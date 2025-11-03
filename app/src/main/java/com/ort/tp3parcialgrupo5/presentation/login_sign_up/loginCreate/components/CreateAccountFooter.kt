package com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography

@Composable
fun CreateAccountScreen() {
    // Solo estado local para render visual de los campos
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.bg_dark_green_black))
            .padding(horizontal = 0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(64.dp))

        Text(
            text = stringResource(R.string.create_account),
            style = AppTypography.displaySmall,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.card_dark_green)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp) 
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 60.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                LoginTextField(
                    label = stringResource(R.string.full_name),
                    value = fullName,
                    onValueChange = { fullName = it },
                    placeholder = "Full name",
                    isPassword = false
                )
                Spacer(Modifier.height(14.dp))

                LoginTextField(
                    label = stringResource(R.string.email),
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "example@example.com",
                    isPassword = false
                )
                Spacer(Modifier.height(14.dp))

                LoginTextField(
                    label = stringResource(R.string.mobile_number),
                    value = mobileNumber,
                    onValueChange = { mobileNumber = it },
                    placeholder = "+ 123 456 789",
                    isPassword = false
                )
                Spacer(Modifier.height(14.dp))

                LoginTextField(
                    label = stringResource(R.string.date_of_birth),
                    value = dateOfBirth,
                    onValueChange = { dateOfBirth = it },
                    placeholder = "DD / MM / YYYY",
                    isPassword = false
                )
                Spacer(Modifier.height(14.dp))

                LoginTextField(
                    label = stringResource(R.string.password),
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "........",
                    isPassword = true // ojo decorativo, no togglea
                )
                Spacer(Modifier.height(14.dp))

                LoginTextField(
                    label = stringResource(R.string.confirm_password),
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = "........",
                    isPassword = true
                )

                Spacer(Modifier.height(18.dp))

                val termsAndPolicy = buildAnnotatedString {
                    append(stringResource(R.string.by_continuing_you_agree) + " ")
                    withStyle(SpanStyle(color = colorResource(R.color.main_green))) {
                        append(stringResource(R.string.terms_of_use))
                    }
                    append(" and ")
                    withStyle(SpanStyle(color = colorResource(R.color.main_green))) {
                        append(stringResource(R.string.privacy_policy))
                    }
                }

                Text(
                    text = termsAndPolicy,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    style = AppTypography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )

                Spacer(Modifier.height(18.dp))

                LoginButton(
                    text = stringResource(R.string.sign_up),
                    onClick = { /* solo visual */ },
                    backgroundColor = colorResource(R.color.main_green),
                    textColor = colorResource(R.color.letters_and_icons),


                )

                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.already_have_an_account),
                        color = Color.Gray,
                        style = AppTypography.bodySmall
                    )
                    TextButton(onClick = { /* solo visual */ }) {
                        Text(
                            text = stringResource(R.string.log_in),
                            color = colorResource(R.color.main_green),
                            style = AppTypography.bodySmall
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAccountScreenPreview() {
    CreateAccountScreen()
}
