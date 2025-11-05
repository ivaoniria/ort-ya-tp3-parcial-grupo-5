package com.ort.tp3parcialgrupo5.presentation.home_screen

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ort.tp3parcialgrupo5.domain.repository.TransactionsRepository
import com.ort.tp3parcialgrupo5.domain.repository.UserRepository

import com.ort.tp3parcialgrupo5.presentation.components.AccountBalanceSection
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.PercentExpensesSection
import com.ort.tp3parcialgrupo5.presentation.home_screen.components.HeaderSection
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
            HeaderSection(onBell = onBell)
            AccountBalanceSection()
            Spacer(modifier.height(10.dp))
            PercentExpensesSection()
            Spacer(modifier.height(18.dp))
        },
        contentBottom = {
            item { SummarySection() }
            item { Spacer(modifier.height(16.dp)) }
            item { PeriodTabs() }
            item { Spacer(modifier.height(12.dp)) }
            item { TransactionListSection() }
            item { Spacer(modifier.height(90.dp)) }
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

