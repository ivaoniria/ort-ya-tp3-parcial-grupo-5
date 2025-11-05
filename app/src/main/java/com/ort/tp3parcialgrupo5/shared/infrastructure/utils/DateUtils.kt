package com.ort.tp3parcialgrupo5.shared.infrastructure.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

object DateUtils {

    private val INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)
    private val SHORT_OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd", Locale.ENGLISH)

    fun formatToShortMonthDay(dateString: String): String =
        runCatching {
            LocalDate.parse(dateString, INPUT_FORMATTER).format(SHORT_OUTPUT_FORMATTER)
        }.getOrElse { dateString }

    fun getFullMonthName(dateString: String): String =
        runCatching {
            LocalDate.parse(dateString, INPUT_FORMATTER)
                .month.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
        }.getOrElse { dateString }
}