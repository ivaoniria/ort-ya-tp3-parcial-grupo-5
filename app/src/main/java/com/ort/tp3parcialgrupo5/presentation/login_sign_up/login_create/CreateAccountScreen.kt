package com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.CreateAccountViewModel
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.components.LoginButton
import com.ort.tp3parcialgrupo5.presentation.login_sign_up.login_create.components.LoginTextField
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography

@Composable
fun CreateAccountScreen(
    viewModel: CreateAccountViewModel = hiltViewModel(),
    onSignUpSuccess: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    BaseLayout(
        contentTop = {
            Text(
                text = stringResource(id = R.string.create_account),
                style = AppTypography.displaySmall,
                color = Color.White
            )
        },
        contentBottom = {
            // Full name
            item {
                LoginTextField(
                    label = stringResource(id = R.string.full_name),
                    value = fullName,
                    onValueChange = { fullName = it },
                    placeholder = stringResource(id = R.string.placeholder_email),
                    isPassword = false
                )
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Email
            item {
                LoginTextField(
                    label = stringResource(id = R.string.email),
                    value = email,
                    onValueChange = { email = it },
                    placeholder = stringResource(id = R.string.placeholder_email),
                    isPassword = false
                )
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Mobile
            item {
                LoginTextField(
                    label = stringResource(id = R.string.mobile_number),
                    value = mobileNumber,
                    onValueChange = { mobileNumber = it },
                    placeholder = stringResource(id = R.string.placeholder_mobile_number),
                    isPassword = false
                )
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Date of Birth
            item {
                LoginTextField(
                    label = stringResource(id = R.string.date_of_birth),
                    value = dateOfBirth,
                    onValueChange = { dateOfBirth = it },
                    placeholder = stringResource(id = R.string.placeholder_dob),
                    isPassword = false
                )
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Password
            item {
                LoginTextField(
                    label = stringResource(id = R.string.password),
                    value = password,
                    onValueChange = { password = it },
                    placeholder = stringResource(id = R.string.placeholder_password),
                    isPassword = true
                )
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Confirm Password
            item {
                LoginTextField(
                    label = stringResource(id = R.string.confirm_password),
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = stringResource(id = R.string.placeholder_password),
                    isPassword = true
                )
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }

            // Terms text
            item {
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
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }

            // Sign Up button
            item {
                LoginButton(
                    text = stringResource(id = R.string.sign_up),
                    onClick = {
                        viewModel.insertUser(
                            username = fullName,
                            email = email
                        )
                        onSignUpSuccess()
                    },
                    backgroundColor = colorResource(id = R.color.main_green),
                    textColor = colorResource(id = R.color.letters_and_icons)
                )
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Footer: login link
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.already_have_an_account),
                        color = Color.Gray
                    )
                    TextButton(onClick = { onLoginClick() }) {
                        Text(
                            text = stringResource(id = R.string.log_in),
                            color = colorResource(id = R.color.main_green)
                        )
                    }
                }
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun CreateAccountScreenPreview() {
    MaterialTheme {
        CreateAccountScreen()
    }
}
