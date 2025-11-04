package com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.components.TransactionRow
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent
import com.ort.tp3parcialgrupo5.ui.theme.TransactionBg

@Composable
fun TransactionListSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(TransactionBg)
            .padding(horizontal = 4.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        TransactionRow(
            iconRes = R.drawable.icon_salary,
            title = stringResource(R.string.salary),
            subtitle = stringResource(R.string.salary_subtitle),
            category = stringResource(R.string.salary_category),
            amount = stringResource(R.string.salary_amount),
            amountColor = Color.White
        )
        TransactionRow(
            iconRes = R.drawable.icon_groceries,
            title = stringResource(R.string.groceries),
            subtitle = stringResource(R.string.groceries_subtitle),
            category = stringResource(R.string.groceries_category),
            amount = stringResource(R.string.groceries_amount),
            amountColor = CyanAccent
        )
        TransactionRow(
            iconRes = R.drawable.icon_rent,
            title = stringResource(R.string.rent),
            subtitle = stringResource(R.string.rent_subtitle),
            category = stringResource(R.string.rent_category),
            amount = stringResource(R.string.rent_amount),
            amountColor = CyanAccent
        )
    }
}

