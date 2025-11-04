package com.ort.tp3parcialgrupo5.presentation.notification.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.presentation.notification.model.NotificationSection

fun LazyListScope.NotificationList(sections: List<NotificationSection>) {
    sections.forEachIndexed { index, section ->
        item {
            if (index != 0) Spacer(Modifier.height(6.dp))
            NotificationSectionHeader(text = stringResource(section.titleRes))
            Spacer(Modifier.height(14.dp))
        }
        items(section.items) { notification ->
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
