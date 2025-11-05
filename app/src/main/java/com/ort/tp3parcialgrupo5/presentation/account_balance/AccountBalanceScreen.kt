package com.ort.tp3parcialgrupo5.presentation.account_balance

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.domain.repository.TransactionsRepository
import com.ort.tp3parcialgrupo5.presentation.components.AccountBalanceSection
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.components.PercentExpensesSection
import com.ort.tp3parcialgrupo5.presentation.account_balance.components.IncomeExpenseSummary
import com.ort.tp3parcialgrupo5.presentation.home_screen.components.TransactionListSection
import com.ort.tp3parcialgrupo5.shared.infrastructure.RetrofitClient
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite
import com.ort.tp3parcialgrupo5.view_model.HomeViewModel
import com.ort.tp3parcialgrupo5.view_model.HomeViewModelFactory

@Composable
fun AccountBalanceScreen(
    modifier: Modifier = Modifier,
    onBack: (() -> Unit),
    onBell: (() -> Unit)
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
            Header(title = stringResource(R.string.account_balance_header), onBack = onBack, onBell = onBell)
            Spacer(modifier.height(10.dp))
            AccountBalanceSection(totalBalance, totalIncome, totalExpense)
            Spacer(modifier.height(10.dp))
            IncomeExpenseSummary(income = totalIncome,
                expense = totalExpense)
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
            item {
                TransactionListSection(transactions)
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewAccountBalanceScreen() {
    MaterialTheme {

    }
}

