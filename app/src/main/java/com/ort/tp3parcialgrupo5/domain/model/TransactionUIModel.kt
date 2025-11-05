package com.ort.tp3parcialgrupo5.domain.model

import androidx.compose.ui.graphics.Color

data class TransactionUIModel(
    val iconRes: Int,
    val category: String,
    val time: String,
    val month: String,
    val amount: String,
    val amountColor: Color
)