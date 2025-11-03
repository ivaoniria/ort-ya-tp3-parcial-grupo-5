package com.ort.tp3parcialgrupo5.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.ExpenseLooksGood

@Composable
fun PercentExpensesSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.check),
            contentDescription = null,
            modifier = Modifier.size(14.dp).padding(0.dp),
            tint = Color.Unspecified
        )
        Spacer(Modifier.width(6.dp))
        Text(
            text = stringResource(R.string.expense_looks_good),
            style = MaterialTheme.typography.bodyMedium,
            color = ExpenseLooksGood
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PercentExpensesSectionScreen() {
    MaterialTheme {
        PercentExpensesSection()
    }
}