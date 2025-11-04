package com.ort.tp3parcialgrupo5.presentation.transaction

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.AccountBalanceSection
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.components.PercentExpensesSection
import com.ort.tp3parcialgrupo5.presentation.components.TransactionRow
import com.ort.tp3parcialgrupo5.presentation.transaction.components.MonthHeader
import com.ort.tp3parcialgrupo5.presentation.transaction.components.TopBalanceCard
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite

@Composable
fun TransactionScreen(
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null
) {
    BaseLayout(
        contentTop = {
            Header(title = stringResource(R.string.transaction_title), onBack = onBack, onBell = onBell)
            TopBalanceCard(title = stringResource(R.string.label_total_balance), amount = stringResource(R.string.total_balance_value))
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
                    TxUi(
                        titleRes = R.string.salary,
                        subtitleRes = R.string.salary_subtitle,
                        categoryRes = R.string.salary_category,
                        amountRes = R.string.salary_amount,
                        positive = true,
                        iconRes = R.drawable.salaryicon
                    ),
                    TxUi(
                        titleRes = R.string.groceries,
                        subtitleRes = R.string.groceries_subtitle,
                        categoryRes = R.string.groceries_category,
                        amountRes = R.string.groceries_amount,
                        positive = false,
                        iconRes = R.drawable.icon_groceries
                    ),
                    TxUi(
                        titleRes = R.string.rent,
                        subtitleRes = R.string.rent_subtitle,
                        categoryRes = R.string.rent_category,
                        amountRes = R.string.rent_amount,
                        positive = false,
                        iconRes = R.drawable.icon_rent
                    ),
                    TxUi(
                        titleRes = R.string.transport,
                        subtitleRes = R.string.transport_subtitle,
                        categoryRes = R.string.transport_category,
                        amountRes = R.string.transport_amount,
                        positive = false,
                        iconRes = R.drawable.icon_transport
                    )
                )
            ) { tx ->
                TransactionRow(
                    iconRes = tx.iconRes,
                    title = stringResource(tx.titleRes),
                    subtitle = stringResource(tx.subtitleRes),
                    category = stringResource(tx.categoryRes),
                    amount = stringResource(tx.amountRes),
                    amountColor = FinWhite
                )
                Spacer(Modifier.height(10.dp))
            }
            item {
                Spacer(Modifier.height(6.dp))
                MonthHeader(text = stringResource(R.string.month_march))
                Spacer(Modifier.height(10.dp))
                TransactionRow(
                    iconRes = R.drawable.icon_food,
                    title = stringResource(R.string.food),
                    subtitle = stringResource(R.string.food_subtitle),
                    category = stringResource(R.string.food_category),
                    amount = stringResource(R.string.food_amount),
                    amountColor = FinWhite
                )
                Spacer(Modifier.height(12.dp))
            }
        }
    )
}

private data class TxUi(
    @StringRes val titleRes: Int,
    @StringRes val subtitleRes: Int,
    @StringRes val categoryRes: Int,
    @StringRes val amountRes: Int,
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
