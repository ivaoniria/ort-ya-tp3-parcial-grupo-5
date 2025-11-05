package com.ort.tp3parcialgrupo5.presentation.transaction.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.ort.tp3parcialgrupo5.ui.theme.TopBalanceCardAmountText
import com.ort.tp3parcialgrupo5.ui.theme.TopBalanceCardBg
import com.ort.tp3parcialgrupo5.ui.theme.TopBalanceCardTitleText
import com.ort.tp3parcialgrupo5.ui.theme.TopBalanceCardAmountText
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TopBalanceCard(
    title: String,
    amount: Double = 0.0,
    modifier: Modifier = Modifier,
    titleStyle: TextStyle = MaterialTheme.typography.titleMedium
) {

    val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US).apply {
        maximumFractionDigits = 2
        minimumFractionDigits = 2
    }

    Surface(
        color = TopBalanceCardBg,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, style = titleStyle, color = TopBalanceCardTitleText)
            Text(text = currencyFormatter.format(amount), color = TopBalanceCardAmountText, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}