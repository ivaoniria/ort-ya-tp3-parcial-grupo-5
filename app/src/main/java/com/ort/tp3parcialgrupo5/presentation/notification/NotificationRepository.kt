package com.ort.tp3parcialgrupo5.presentation.notification

import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.notification.model.NotificationItem
import com.ort.tp3parcialgrupo5.presentation.notification.model.NotificationSection

object NotificationRepository {
    fun getSections(): List<NotificationSection> = listOf(
        NotificationSection(
            titleRes = R.string.section_today,
            items = today()
        ),
        NotificationSection(
            titleRes = R.string.section_yesterday,
            items = yesterday()
        ),
        NotificationSection(
            titleRes = R.string.section_this_weekend,
            items = weekend()
        )
    )

    private fun today(): List<NotificationItem> = listOf(
        NotificationItem(
            iconRes = R.drawable.vector_bell,
            titleRes = R.string.notif_title_reminder,
            bodyRes = R.string.notif_body_savings,
            timeRes = R.string.notif_time_example
        ),
        NotificationItem(
            iconRes = R.drawable.vector_star,
            titleRes = R.string.notif_title_new_update,
            bodyRes = R.string.notif_body_savings,
            timeRes = R.string.notif_time_example
        )
    )

    private fun yesterday(): List<NotificationItem> = listOf(
        NotificationItem(
            iconRes = R.drawable.vector__1_dolar,
            titleRes = R.string.notif_title_transactions,
            bodyRes = R.string.notif_body_registered,
            timeRes = R.string.notif_time_example,
            detailRes = R.string.notif_detail_groceries
        ),
        NotificationItem(
            iconRes = R.drawable.vector_bell,
            titleRes = R.string.notif_title_reminder,
            bodyRes = R.string.notif_body_savings,
            timeRes = R.string.notif_time_example
        )
    )

    private fun weekend(): List<NotificationItem> = listOf(
        NotificationItem(
            iconRes = R.drawable.vector_2_down,
            titleRes = R.string.notif_title_expense_record,
            bodyRes = R.string.notif_body_recommendation,
            timeRes = R.string.notif_time_example
        ),
        NotificationItem(
            iconRes = R.drawable.vector__1_dolar,
            titleRes = R.string.notif_title_transactions,
            bodyRes = R.string.notif_body_registered,
            timeRes = R.string.notif_time_example,
            detailRes = R.string.notif_detail_food
        )
    )
}

