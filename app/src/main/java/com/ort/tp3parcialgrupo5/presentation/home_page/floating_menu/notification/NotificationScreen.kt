package com.ort.tp3parcialgrupo5.presentation.home_page.notification

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.home_page.floating_menu.notification.components.NotificationItemRow
import com.ort.tp3parcialgrupo5.presentation.home_page.floating_menu.notification.components.NotificationSectionHeader
import com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components.BaseShapeBackground

@Composable
fun NotificationScreen(onBack: (() -> Unit)? = null, onBell: (() -> Unit)? = null) {
    val BgDark = Color(5, 34, 36)
    val Panel = Color(9, 48, 48)

    val today = listOf(
        NotiUi(R.drawable.icon_notificationbellblue, R.string.notif_title_reminder, R.string.notif_body_savings, "17:00 - April 24", null),
        NotiUi(R.drawable.group_star, R.string.notif_title_new_update, R.string.notif_body_savings, "17:00 - April 24", null)
    )
    val yesterday = listOf(
        NotiUi(R.drawable.group_dolar, R.string.notif_title_transactions, R.string.notif_body_registered, "17:00 - April 24", "Groceries | Pantry | -$100,00"),
        NotiUi(R.drawable.icon_notificationbellblue, R.string.notif_title_reminder, R.string.notif_body_savings, "17:00 - April 24", null)
    )
    val thisWeekend = listOf(
        NotiUi(R.drawable.car, R.string.notif_title_expense_record, R.string.notif_body_recommendation, "17:00 - April 24", null),
        NotiUi(R.drawable.group_dolar, R.string.notif_title_transactions, R.string.notif_body_registered, "17:00 - April 24", "Food | Dinner | -$70,40")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgDark)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Header(
                title = stringResource(R.string.notification_title),
                onBack = onBack,
                onBell = onBell,
                bellIcon = R.drawable.icon_notificationbellblue
            )
            Spacer(Modifier.height(12.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            BaseShapeBackground(
                panelColor = Panel,
                cornerRadiusDp = 28.dp,
                heightFraction = 1f,
                mirrorHorizontally = true,
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 18.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 12.dp)
                ) {
                    item {
                        NotificationSectionHeader(text = stringResource(R.string.section_today))
                        Spacer(Modifier.height(14.dp))
                    }
                    items(today) { n ->
                        NotificationItemRow(
                            iconRes = n.iconRes,
                            title = stringResource(n.titleRes),
                            body = stringResource(n.bodyRes),
                            rightTime = n.rightTime,
                            bottomAccent = n.bottomAccent
                        )
                        Spacer(Modifier.height(6.dp))
                    }

                    item {
                        Spacer(Modifier.height(6.dp))
                        NotificationSectionHeader(text = stringResource(R.string.section_yesterday))
                        Spacer(Modifier.height(14.dp))
                    }
                    items(yesterday) { n ->
                        NotificationItemRow(
                            iconRes = n.iconRes,
                            title = stringResource(n.titleRes),
                            body = stringResource(n.bodyRes),
                            rightTime = n.rightTime,
                            bottomAccent = n.bottomAccent
                        )
                        Spacer(Modifier.height(6.dp))
                    }

                    item {
                        Spacer(Modifier.height(6.dp))
                        NotificationSectionHeader(text = stringResource(R.string.section_this_weekend))
                        Spacer(Modifier.height(14.dp))
                    }
                    items(thisWeekend) { n ->
                        NotificationItemRow(
                            iconRes = n.iconRes,
                            title = stringResource(n.titleRes),
                            body = stringResource(n.bodyRes),
                            rightTime = n.rightTime,
                            bottomAccent = n.bottomAccent
                        )
                        Spacer(Modifier.height(6.dp))
                    }
                }
            }
        }
    }
}

private data class NotiUi(
    val iconRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val bodyRes: Int,
    val rightTime: String,
    val bottomAccent: String?
)

@Preview(showSystemUi = true)
@Composable
private fun PreviewNotificationScreen() {
    MaterialTheme { NotificationScreen() }
}