package com.ort.tp3parcialgrupo5.presentation.home_page.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.presentation.components.AccountBalanceSection
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components.HeaderSection
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components.PeriodTabs
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components.SummarySection
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components.TransactionListSection

@Composable
fun HomePageScreen(
    modifier: Modifier = Modifier,
    onBell: (() -> Unit)? = null
) {
    Scaffold(containerColor = Color.Transparent, bottomBar = {}) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF093030))
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 28.dp, bottom = 90.dp),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                item { HeaderSection(onBell = onBell) }
                item { Spacer(Modifier.height(40.dp)) }
                item { AccountBalanceSection() }
                item { Spacer(Modifier.height(18.dp)) }
                item { SummarySection() }
                item { Spacer(Modifier.height(16.dp)) }
                item { PeriodTabs() }
                item { Spacer(Modifier.height(12.dp)) }
                item { TransactionListSection() }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewHomePageScreen() {
    MaterialTheme {
        HomePageScreen()
    }
}

