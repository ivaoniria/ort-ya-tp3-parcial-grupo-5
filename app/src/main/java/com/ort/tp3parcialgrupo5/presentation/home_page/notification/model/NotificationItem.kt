package com.ort.tp3parcialgrupo5.presentation.home_page.notification.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class NotificationItem(
    @DrawableRes val iconRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val bodyRes: Int,
    @StringRes val timeRes: Int,
    @StringRes val detailRes: Int? = null
)

