package com.ort.tp3parcialgrupo5.presentation.home_page.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components.AccountBalanceSection
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components.HeaderSection
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components.PeriodTabs
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components.SummarySection
import com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components.TransactionListSection
import com.ort.tp3parcialgrupo5.ui.theme.TealDark
import com.ort.tp3parcialgrupo5.ui.theme.homeGradient

@Composable
fun HomePageScreen(modifier: Modifier = Modifier) {
    Scaffold(containerColor = Color.Transparent, bottomBar = {}) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(homeGradient())
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 28.dp, bottom = 90.dp)
            ) {
                item { HeaderSection() }
                item { Spacer(Modifier.height(6.dp)) }
                item { AccountBalanceSection() }
                item { Spacer(Modifier.height(18.dp)) }
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                            .background(TealDark)
                            .padding(top = 24.dp, start = 12.dp, end = 12.dp, bottom = 12.dp)
                    ) {
                        Column {
                            SummarySection()
                            Spacer(Modifier.height(16.dp))
                            PeriodTabs()
                            Spacer(Modifier.height(12.dp))
                            TransactionListSection()
                        }
                    }
                }
            }
        }
    }
}
