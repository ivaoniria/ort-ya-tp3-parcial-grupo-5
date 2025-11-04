package com.ort.tp3parcialgrupo5.presentation.transaction.model

import androidx.annotation.StringRes

data class TxUi(
    @StringRes val titleRes: Int,
    @StringRes val subtitleRes: Int,
    @StringRes val categoryRes: Int,
    @StringRes val amountRes: Int,
    val positive: Boolean,
    val iconRes: Int
)
