package com.ort.tp3parcialgrupo5.presentation.login_sign_up.loginCreate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
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
    // Label
    Text(
        text = label,
        style = AppTypography.titleSmall,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, bottom = 6.dp)
    )

    val bg = colorResource(R.color.bg_green_white)
    val txt = colorResource(R.color.letters_and_icons)

    // Contenedor pill con altura y padding exactos (↓ menos padding vertical)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp) // controlás la altura total del input
            .background(bg, RoundedCornerShape(50))
            .padding(start = 16.dp, end = 12.dp, top = 6.dp, bottom = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = AppTypography.bodyMedium.copy(color = txt),
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                cursorBrush = SolidColor(colorResource(R.color.main_green)),
                modifier = Modifier.weight(1f)
            ) { inner ->
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = AppTypography.bodyMedium,
                        color = txt.copy(alpha = 0.5f)
                    )
                }
                inner()
            }

            if (isPassword) {
                Icon(
                    painter = painterResource(id = R.drawable.eye_pass),
                    contentDescription = null,
                    tint = txt
                )
            }
        }
    }
}
