package com.ort.tp3parcialgrupo5.presentation.login_sign_up.forgot_reset_password.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R

@Composable
fun ForgotPasswordFooter() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(horizontal = 40.dp)) {
            ForgotPasswordButton(
                text = stringResource(id = R.string.sign_up),
                onClick = { /*TODO*/ },
                backgroundColor = colorResource(id = R.color.bg_green_white),
                textColor = colorResource(id = R.color.letters_and_icons)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = stringResource(id = R.string.facebook_desc)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = stringResource(id = R.string.google_desc)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = R.string.dont_have_account), color = Color.Gray)
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.sign_up), color = colorResource(id = R.color.main_green))
            }
        }
    }
}