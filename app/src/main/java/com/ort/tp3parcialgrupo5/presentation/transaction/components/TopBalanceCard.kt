package com.ort.tp3parcialgrupo5.presentation.transaction.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.ui.theme.TopBalanceCardBg
import com.ort.tp3parcialgrupo5.ui.theme.TopBalanceCardTitleText
import com.ort.tp3parcialgrupo5.ui.theme.TopBalanceCardAmountText

@Composable
fun TopBalanceCard(
    title: String,
    amount: String,
    modifier: Modifier = Modifier
) {
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
            Text(title, color = TopBalanceCardTitleText, fontSize = 13.sp)
            Text(amount, color = TopBalanceCardAmountText, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}