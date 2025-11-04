package com.ort.tp3parcialgrupo5.presentation.home_page.transaction

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.AccountBalanceSection
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.components.PercentExpensesSection
import com.ort.tp3parcialgrupo5.presentation.components.TransactionRow
import com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components.MonthHeader
import com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components.TopBalanceCard
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent

@Composable
fun TransactionScreen(
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null
) {
    BaseLayout(
        contentTop= {
            Header(title= stringResource(R.string.transaction_title), onBack = onBack, onBell = onBell)
            TopBalanceCard(title = stringResource(R.string.label_total_balance), amount = "$7,783.00")
            Spacer(Modifier.height(12.dp))
            AccountBalanceSection()
            Spacer(Modifier.height(10.dp))
            PercentExpensesSection()
            Spacer(Modifier.height(10.dp))
        },
        contentBottom = {
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
                    iconRes = tx.iconRes,
                    title = tx.title,
                    subtitle = tx.subtitle,
                    category = tx.category,
                    amount = tx.amount,
                    amountColor = Color.White
                )
                Spacer(Modifier.height(10.dp))
            }
            item {
                Spacer(Modifier.height(6.dp))
                MonthHeader(text = stringResource(R.string.month_march))
                Spacer(Modifier.height(10.dp))
                TransactionRow(
                    iconRes = R.drawable.icon_food,
                    title = "Food",
                    subtitle = "19:30 - March 31",
                    category = "Dinner",
                    amount = "-$70.40",
                    amountColor = CyanAccent
                )
                Spacer(Modifier.height(12.dp))
            }
        }
    )
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