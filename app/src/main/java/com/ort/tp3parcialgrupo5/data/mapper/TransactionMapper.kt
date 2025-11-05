package com.ort.tp3parcialgrupo5.data.mapper

import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.domain.model.TransactionUIModel
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto.TransactionResponse
import com.ort.tp3parcialgrupo5.shared.infrastructure.utils.CurrencyFormatUtils
import com.ort.tp3parcialgrupo5.shared.infrastructure.utils.DateUtils
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite

fun TransactionResponse.toUiModel(): TransactionUIModel {
    val iconRes = when (subtype.lowercase()) {
        "salary" -> R.drawable.icon_salary
        "clothes" -> R.drawable.icon_groceries
        "services" -> R.drawable.icon_transport
        "food" -> R.drawable.icon_food
        else -> R.drawable.icon_food
    }

    val formattedAmount = CurrencyFormatUtils.formatAmount(amount, type, currency)

    val amountColor = if (type.lowercase() == "income") FinWhite else CyanAccent

    val dateText = DateUtils.formatToShortMonthDay(date)
    val monthText = DateUtils.getFullMonthName(date)

    return TransactionUIModel(
        iconRes = iconRes,
        category = subtype.lowercase(),
        time = dateText,
        month = monthText,
        amount = formattedAmount,
        amountColor = amountColor
    )
}
