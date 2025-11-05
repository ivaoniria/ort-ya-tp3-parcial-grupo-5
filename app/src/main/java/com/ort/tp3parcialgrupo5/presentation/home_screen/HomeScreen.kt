package com.ort.tp3parcialgrupo5.presentation.home_screen

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
import com.ort.tp3parcialgrupo5.presentation.home_screen.components.PeriodTabs
import com.ort.tp3parcialgrupo5.presentation.home_screen.components.SummarySection
import com.ort.tp3parcialgrupo5.presentation.home_screen.components.TransactionListSection
import com.ort.tp3parcialgrupo5.shared.infrastructure.RetrofitClient
import com.ort.tp3parcialgrupo5.view_model.HomeViewModel
import com.ort.tp3parcialgrupo5.view_model.HomeViewModelFactory

@Composable
fun HomePageScreen(
    modifier: Modifier = Modifier,
    onBell: (() -> Unit)? = null
) {
    val homeViewModel: HomeViewModel = viewModel(
        factory = HomeViewModelFactory(
            TransactionsRepository(RetrofitClient.transactionsApi)
        )
    )

    val totalBalance by homeViewModel.totalBalance
    val totalExpense by homeViewModel.totalExpense
    val transactions by homeViewModel.transactions

    BaseLayout(
        contentTop = {
            Header(
                welcomeTitle = stringResource(R.string.hi_welcome_back),
                welcomeSubtitle = stringResource(R.string.good_morning),
                onBack = null,
                onBell = onBell,
                paddingStartDp = 0.dp,
                paddingEndDp = 0.dp,
                headerYOffsetDp = (-12).dp
            )
            Spacer(Modifier.height(12.dp))
            AccountBalanceSection()
            Spacer(Modifier.height(10.dp))
            PercentExpensesSection()
            Spacer(Modifier.height(18.dp))
        },
        contentBottom = {
            item { SummarySection() }
            item { Spacer(Modifier.height(16.dp)) }
            item { PeriodTabs() }
            item { Spacer(Modifier.height(12.dp)) }
            item { TransactionListSection() }
            item { Spacer(Modifier.height(90.dp)) }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewHomePageScreen() {
    MaterialTheme {
        HomePageScreen()
    }
}
