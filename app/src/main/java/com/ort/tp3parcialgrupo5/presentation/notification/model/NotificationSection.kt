package com.ort.tp3parcialgrupo5.presentation.notification.model

import androidx.annotation.StringRes

data class NotificationSection(
    @StringRes val titleRes: Int,
    val items: List<NotificationItem>
)
