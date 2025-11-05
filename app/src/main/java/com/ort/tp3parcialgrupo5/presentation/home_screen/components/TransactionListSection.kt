package com.ort.tp3parcialgrupo5.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.ort.tp3parcialgrupo5.data.mapper.toUiModel
import com.ort.tp3parcialgrupo5.presentation.components.TransactionRow
import com.ort.tp3parcialgrupo5.shared.infrastructure.transactions.dto.TransactionResponse
import com.ort.tp3parcialgrupo5.ui.theme.TransactionBg

@Composable
fun TransactionListSection(
    transactions: List<TransactionResponse>,
    modifier: Modifier = Modifier
) {
    val transactionUiList = transactions.map { it.toUiModel() }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(TransactionBg)
    ) {
        transactionUiList.forEach { uiModel ->
            TransactionRow(
                iconRes = uiModel.iconRes,
                category = uiModel.category,
                time = uiModel.time,
                month = uiModel.month,
                amount = uiModel.amount,
                amountColor = uiModel.amountColor
            )
        }
    }
}