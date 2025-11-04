package com.ort.tp3parcialgrupo5.presentation.notification

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.notification.components.NotificationItemRow
import com.ort.tp3parcialgrupo5.presentation.notification.components.NotificationSectionHeader
import com.ort.tp3parcialgrupo5.presentation.notification.NotificationItem
import com.ort.tp3parcialgrupo5.presentation.transaction.components.BaseShapeBackground
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

private val PanelColor = Color(9, 48, 48)

@Composable
fun NotificationScreen(
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null
) {
    BaseLayout(
        contentTop = {
            Header(
                title = stringResource(R.string.notification_title),
                onBack = onBack,
                onBell = onBell,
                bellIcon = R.drawable.icon_notificationbellblue
            )
            Spacer(Modifier.height(12.dp))
        },
        contentBottom = {
            item {
                NotificationContent()
            }
        }
    )
}

@Composable
private fun NotificationContent() {
    val todayNotifications = getTodayNotifications()
    val yesterdayNotifications = getYesterdayNotifications()
    val thisWeekendNotifications = getThisWeekendNotifications()

    BaseShapeBackground(
        panelColor = PanelColor,
        cornerRadiusDp = 28.dp,
        heightFraction = 1f,
        mirrorHorizontally = true,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 18.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 12.dp)
        ) {
            // Today Section
            item {
                NotificationSectionHeader(
                    text = stringResource(R.string.section_today)
                )
                Spacer(Modifier.height(14.dp))
            }

            items(todayNotifications) { notification ->
                NotificationItemRow(
                    iconRes = notification.iconRes,
                    title = stringResource(notification.titleRes),
                    body = stringResource(notification.bodyRes),
                    rightTime = stringResource(notification.timeRes),
                    bottomAccent = notification.detailRes?.let { stringResource(it) }
                )
                Spacer(Modifier.height(6.dp))
            }

            // Yesterday Section
            item {
                Spacer(Modifier.height(6.dp))
                NotificationSectionHeader(
                    text = stringResource(R.string.section_yesterday)
                )
                Spacer(Modifier.height(14.dp))
            }

            items(yesterdayNotifications) { notification ->
                NotificationItemRow(
                    iconRes = notification.iconRes,
                    title = stringResource(notification.titleRes),
                    body = stringResource(notification.bodyRes),
                    rightTime = stringResource(notification.timeRes),
                    bottomAccent = notification.detailRes?.let { stringResource(it) }
                )
                Spacer(Modifier.height(6.dp))
            }

            // This Weekend Section
            item {
                Spacer(Modifier.height(6.dp))
                NotificationSectionHeader(
                    text = stringResource(R.string.section_this_weekend)
                )
                Spacer(Modifier.height(14.dp))
            }

            items(thisWeekendNotifications) { notification ->
                NotificationItemRow(
                    iconRes = notification.iconRes,
                    title = stringResource(notification.titleRes),
                    body = stringResource(notification.bodyRes),
                    rightTime = stringResource(notification.timeRes),
                    bottomAccent = notification.detailRes?.let { stringResource(it) }
                )
                Spacer(Modifier.height(6.dp))
            }
        }
    }
}

private fun getTodayNotifications(): List<NotificationItem> = listOf(
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

private fun getYesterdayNotifications(): List<NotificationItem> = listOf(
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

private fun getThisWeekendNotifications(): List<NotificationItem> = listOf(
    NotificationItem(
        iconRes = R.drawable.vector_2_down,
        titleRes = R.string.notif_title_expense_record,
        bodyRes = R.string.notif_body_recommendation,
        timeRes = R.string.notif_time_example
    ),
    NotificationItem(
        iconRes = R.drawable.group_dolar,
        titleRes = R.string.notif_title_transactions,
        bodyRes = R.string.notif_body_registered,
        timeRes = R.string.notif_time_example,
        detailRes = R.string.notif_detail_food
    )
)

@Preview(showSystemUi = true)
@Composable
private fun PreviewNotificationScreen() {
    MaterialTheme { NotificationScreen() }
}