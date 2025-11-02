package com.ort.tp3parcialgrupo5.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.ui.theme.TransactionBg

@Composable
fun TransactionListContainer(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(TransactionBg)
            .padding(horizontal = 4.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        content = content
    )
}

