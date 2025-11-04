package com.ort.tp3parcialgrupo5.presentation.account_balance

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R

import com.ort.tp3parcialgrupo5.presentation.components.AccountBalanceSection
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.components.PercentExpensesSection
import com.ort.tp3parcialgrupo5.presentation.components.TransactionRow
import com.ort.tp3parcialgrupo5.presentation.account_balance.components.IncomeExpenseSummary
import com.ort.tp3parcialgrupo5.presentation.transaction.model.TxUi
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite

@Composable
fun AccountBalanceScreen(
    modifier: Modifier = Modifier,
    onBack: (() -> Unit),
    onBell: (() -> Unit)
) {
    BaseLayout(
        contentTop = {
            Header(title = stringResource(R.string.account_balance_header), onBack = onBack, onBell = onBell)
            AccountBalanceSection()
            Spacer(modifier.height(10.dp))
            IncomeExpenseSummary(income = stringResource(R.string.income_summary_value),
                expense = stringResource(R.string.expense_summary_value))
            Spacer(modifier.height(10.dp))
            PercentExpensesSection()
            Spacer(modifier.height(18.dp))
        },
        contentBottom = {
            item {
                Text(
                    text = stringResource(R.string.transactions_section_title),
                    color = FinWhite,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                    textAlign = TextAlign.Start
                )
            }
            item { Spacer(modifier.height(12.dp)) }
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
            }
            item { Spacer(modifier.height(90.dp)) }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewAccountBalanceScreen() {
    MaterialTheme {

    }
}

