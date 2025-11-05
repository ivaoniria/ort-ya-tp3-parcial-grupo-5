package com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.AppTypography

@Composable
fun PinEntryCircle(number: Int) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .border(2.dp, colorResource(id = R.color.main_green), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            style = AppTypography.titleMedium,
            color = colorResource(id = R.color.main_green)
        )
    }
}