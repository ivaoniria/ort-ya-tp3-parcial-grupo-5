package com.ort.tp3parcialgrupo5.presentation.account_balance.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite

@Composable
fun IncomeExpenseSummary(
    income: Double = 0.0,
    expense: Double = 0.0,
    incomeColor: Color = FinWhite,
    expenseColor: Color = CyanAccent,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SummaryCard(
                title = "Income",
                amount = income,
                icon = ImageVector.vectorResource(R.drawable.flechatotalbalance),
                iconTint = incomeColor,
                backgroundColor = Color.White,
                modifier = Modifier.weight(1f).fillMaxWidth()
            )
            SummaryCard(
                title = "Expense",
                amount = expense,
                icon = ImageVector.vectorResource(R.drawable.flechatotalexpense),
                iconTint = expenseColor,
                backgroundColor = Color.White,
                modifier = Modifier.weight(1f).fillMaxWidth()
            )
        }
    }
}
