package com.ort.tp3parcialgrupo5.presentation.home_page.transaction

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
import com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components.BaseShapeBackground
import com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components.HomeTotalsSection
import com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components.MonthHeader
import com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components.TopBalanceCard
import com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components.TransactionRow

@Composable
fun TransactionScreen(
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null
) {
    val BgDark = Color(5, 34, 36)
    val Panel = Color(14, 62, 62)

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
            Header(title = stringResource(R.string.transaction_title), onBack = onBack, onBell = onBell)
            Spacer(Modifier.height(12.dp))
            TopBalanceCard(title = stringResource(R.string.label_total_balance), amount = "$7,783.00")
            Spacer(Modifier.height(12.dp))
            HomeTotalsSection(
                balanceLabel = stringResource(R.string.label_total_balance),
                balanceValue = "$7,783.00",
                expenseLabel = stringResource(R.string.label_total_expense),
                expenseValue = "-$1,187.40",
                progressFraction = 0.30f,
                progressTextLeft = "30%",
                goalPillText = "$20,000.00",
                note = stringResource(R.string.summary_note_default)
            )
            Spacer(Modifier.height(10.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            BaseShapeBackground(
                baseShapeRes = R.drawable.base_shape,
                panelColor = Panel,
                cornerRadiusDp = 28.dp,
                heightFraction = 1f,
                mirrorHorizontally = true,
                mirrorVertically = false,
                yOffset = 0.dp,
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 18.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 12.dp)
                ) {
                    item {
                        MonthHeader(text = stringResource(R.string.month_april))
                        Spacer(Modifier.height(10.dp))
                    }
                    items(
                        listOf(
                            TxUi("Salary", "18:27 - April 30", "Monthly", "$4,000.00", true, R.drawable.salaryicon),
                            TxUi("Groceries", "17:00 - April 24", "Pantry", "-$100.00", false, R.drawable.icon_groceries),
                            TxUi("Rent", "8:30 - April 15", "Rent", "-$674.40", false, R.drawable.icon_rent),
                            TxUi("Transport", "9:30 - April 08", "Fuel", "-$4.13", false, R.drawable.icon_transport)
                        )
                    ) { tx ->
                        TransactionRow(
                            title = tx.title,
                            subtitle = tx.subtitle,
                            category = tx.category,
                            amount = tx.amount,
                            positive = tx.positive,
                            iconRes = tx.iconRes
                        )
                        Spacer(Modifier.height(10.dp))
                    }
                    item {
                        Spacer(Modifier.height(6.dp))
                        MonthHeader(text = stringResource(R.string.month_march))
                        Spacer(Modifier.height(10.dp))
                        TransactionRow(
                            title = "Food",
                            subtitle = "19:30 - March 31",
                            category = "Dinner",
                            amount = "-$70.40",
                            positive = false,
                            iconRes = R.drawable.icon_food
                        )
                        Spacer(Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

private data class TxUi(
    val title: String,
    val subtitle: String,
    val category: String,
    val amount: String,
    val positive: Boolean,
    val iconRes: Int
)

@Preview(showSystemUi = true)
@Composable
private fun PreviewTransactionScreen() {
    MaterialTheme {
        TransactionScreen()
    }
}