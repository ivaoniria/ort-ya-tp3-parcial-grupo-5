package com.ort.tp3parcialgrupo5.presentation.categories

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @DrawableRes val iconRes: Int,
    @StringRes val nameRes: Int,
    val isSpecialColor: Boolean = false
)