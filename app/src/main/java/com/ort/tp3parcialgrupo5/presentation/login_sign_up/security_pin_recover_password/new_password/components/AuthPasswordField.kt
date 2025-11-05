package com.ort.tp3parcialgrupo5.presentation.login_sign_up.security_pin_recover_password.new_password.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R

private val DefaultFieldBg = Color(0xFFE0F8D7)
private val DefaultFieldText = Color(0xFF002B29)

@Composable
fun AuthPasswordField(
    @StringRes labelRes: Int,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = DefaultFieldBg,
    textColor: Color = DefaultFieldText,
    @DrawableRes eyeIcon: Int = R.drawable.eye_pass
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(id = labelRes),
            color = Color.White,
            fontSize = 13.sp,
        )
        Spacer(Modifier.height(6.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor, shape = RoundedCornerShape(50.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = "•".repeat(value.length),
                onValueChange = onValueChange,
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(
                    color = textColor,
                    fontSize = 14.sp
                ),
                singleLine = true
            )
            Spacer(Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = eyeIcon),
                contentDescription = stringResource(id = labelRes),
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(22.dp)
                    .clickable(enabled = false) { }
            )
        }
    }
}