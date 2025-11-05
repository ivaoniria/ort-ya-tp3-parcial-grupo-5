package com.ort.tp3parcialgrupo5.shared.infrastructure.utils

import java.text.NumberFormat
import java.util.Locale

object CurrencyFormatUtils {
    fun formatAmount(amount: Double, type: String, currencyCode: String): String {
        val currencyFormat = NumberFormat.getCurrencyInstance(Locale.US)
        val formatted = currencyFormat.format(amount)

        return if (type.lowercase() == "expense") {
            "-$formatted"
        } else {
            formatted
        }
    }
}