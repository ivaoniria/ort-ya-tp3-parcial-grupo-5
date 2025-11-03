package com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography

@Composable
fun LoginTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean
) {
    Text(
        text = label,
        style = AppTypography.titleSmall,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, bottom = 4.dp)
    )
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(50),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if (isPassword) {
                Icon(
                    painter = painterResource(id = R.drawable.eye_pass),
                    contentDescription = null,
                    tint = colorResource(id = R.color.letters_and_icons)
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = colorResource(id = R.color.bg_green_white),
            focusedContainerColor = colorResource(id = R.color.bg_green_white),
            unfocusedTextColor = colorResource(id = R.color.letters_and_icons),
            focusedTextColor = colorResource(id = R.color.letters_and_icons),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            cursorColor = colorResource(id = R.color.main_green),
            unfocusedPlaceholderColor = colorResource(id = R.color.letters_and_icons).copy(alpha = 0.5f),
            focusedPlaceholderColor = colorResource(id = R.color.letters_and_icons).copy(alpha = 0.5f)
        )
    )
}