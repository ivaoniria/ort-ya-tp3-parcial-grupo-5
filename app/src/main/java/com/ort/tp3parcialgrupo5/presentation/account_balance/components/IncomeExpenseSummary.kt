package com.ort.tp3parcialgrupo5.presentation.account_balance.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

import com.ort.tp3parcialgrupo5.ui.theme.FinWiseTheme
import com.ort.tp3parcialgrupo5.R

@Composable
fun IncomeExpenseSummary(
    income: String,
    expense: String,
    incomeColor: Color = Color(0xFF00D09E),
    expenseColor: Color = Color(0xFF11A3FF),
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewIncomeExpenseSummary() {
    FinWiseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF093030)),
            contentAlignment = Alignment.Center
        ) {
            IncomeExpenseSummary(
                income = "$4,000.00",
                expense = "$1,187.40"
            )
        }
    }
}