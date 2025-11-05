package com.ort.tp3parcialgrupo5.presentation.notification

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.notification.components.NotificationList

@Composable
fun NotificationScreen(
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null
) {
    BaseLayout(
        contentTop = {
            Header(
                title = stringResource(R.string.notifications),
                onBack = onBack,
                onBell = onBell,
                isNotification = true
            )
            Spacer(Modifier.height(12.dp))
        },
        contentBottom = {
            NotificationList(
                sections = NotificationRepository.getSections()
            )
        }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewNotificationScreen() {
    MaterialTheme { NotificationScreen() }
}
