package com.ort.tp3parcialgrupo5.presentation.profile.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite

@Composable
fun ProfileInfo(
    @DrawableRes imageRes: Int,
    @StringRes nameRes: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = stringResource(id = nameRes),
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = stringResource(id = nameRes),
            fontSize = 16.sp,
            color = FinWhite
        )
    }
}