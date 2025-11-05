package com.ort.tp3parcialgrupo5.presentation.transaction

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.domain.repository.TransactionsRepository
import com.ort.tp3parcialgrupo5.presentation.components.AccountBalanceSection
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.components.PercentExpensesSection
import com.ort.tp3parcialgrupo5.presentation.components.TransactionRow
import com.ort.tp3parcialgrupo5.presentation.home_screen.components.TransactionListSection
import com.ort.tp3parcialgrupo5.presentation.transaction.components.MonthHeader
import com.ort.tp3parcialgrupo5.presentation.transaction.components.TopBalanceCard
import com.ort.tp3parcialgrupo5.shared.infrastructure.RetrofitClient
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite
import com.ort.tp3parcialgrupo5.presentation.home_screen.HomeViewModel
import com.ort.tp3parcialgrupo5.presentation.home_screen.HomeViewModelFactory

@Composable
fun TransactionScreen(
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null
) {
    val homeViewModel: HomeViewModel = viewModel(
        factory = HomeViewModelFactory(
            TransactionsRepository(RetrofitClient.transactionsApi)
        )
    )

    val totalBalance by homeViewModel.totalBalance
    val totalIncome by homeViewModel.totalIncome
    val totalExpense by homeViewModel.totalExpense
    val transactions by homeViewModel.transactions

    BaseLayout(
        contentTop = {
            Header(title = stringResource(R.string.transaction_title), onBack = onBack, onBell = onBell)
            TopBalanceCard(
                title = stringResource(R.string.label_total_balance),
                amount = totalBalance,
                titleStyle = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(12.dp))
            AccountBalanceSection(totalBalance, totalIncome, totalExpense)
            Spacer(Modifier.height(10.dp))
            PercentExpensesSection()
            Spacer(Modifier.height(10.dp))
        },
        contentBottom = {
            item {
                MonthHeader(text = stringResource(R.string.month_october))
                Spacer(Modifier.height(10.dp))
            }
            item {
                TransactionListSection(transactions)
            }
            item {
                Spacer(Modifier.height(10.dp))
            }
            item {
                Spacer(Modifier.height(6.dp))
                MonthHeader(text = stringResource(R.string.month_november))
                Spacer(Modifier.height(10.dp))
                TransactionRow(
                    iconRes = R.drawable.icon_food,
                    category = stringResource(R.string.food),
                    time = stringResource(R.string.food_time),
                    month = stringResource(R.string.food_category),
                    amount = stringResource(R.string.food_amount),
                    amountColor = FinWhite
                )
                Spacer(Modifier.height(12.dp))
            }
            item {
                Spacer(Modifier.height(12.dp))
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewTransactionScreen() {
    MaterialTheme {
        TransactionScreen()
    }
}
