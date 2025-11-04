package com.ort.tp3parcialgrupo5.presentation.home_screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.ort.tp3parcialgrupo5.presentation.components.AccountBalanceSection
import com.ort.tp3parcialgrupo5.presentation.components.BaseLayout
import com.ort.tp3parcialgrupo5.presentation.components.PercentExpensesSection
import com.ort.tp3parcialgrupo5.presentation.home_screen.components.HeaderSection
import com.ort.tp3parcialgrupo5.presentation.home_screen.components.PeriodTabs
import com.ort.tp3parcialgrupo5.presentation.home_screen.components.SummarySection
import com.ort.tp3parcialgrupo5.presentation.home_screen.components.TransactionListSection

@Composable
fun HomePageScreen(
    modifier: Modifier = Modifier,
    onBell: (() -> Unit)? = null
) {

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

