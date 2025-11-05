package com.ort.tp3parcialgrupo5.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.AccountBalanceAmount
import com.ort.tp3parcialgrupo5.ui.theme.AccountBalanceDivider
import com.ort.tp3parcialgrupo5.ui.theme.AccountBalanceLabel
import com.ort.tp3parcialgrupo5.ui.theme.BlueButton
import java.text.NumberFormat
import java.util.Locale

private fun parseNumber(raw: String): Double =
    raw.replace(",", "").trim().toDoubleOrNull() ?: 0.0

@Composable
fun AccountBalanceSection(
    modifier: Modifier = Modifier
) {
    val totalBalanceVal = parseNumber(stringResource(R.string.total_balance_value))
    val totalExpenseVal = parseNumber(stringResource(R.string.total_expense_value))
    val progressPercentVal = stringResource(R.string.progress_percent_value).trim().toIntOrNull() ?: 0
    val goalTargetUsdVal = parseNumber(stringResource(R.string.goal_target_usd_value))

    val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US).apply {
        maximumFractionDigits = 2
        minimumFractionDigits = 2
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.flechatotalbalance),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = stringResource(R.string.total_balance),
                        style = MaterialTheme.typography.bodyMedium,
                        color = AccountBalanceLabel
                    )
                }
                Text(
                    text = currencyFormatter.format(totalBalanceVal),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = AccountBalanceAmount
                )
            }

            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(AccountBalanceDivider)
            )

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.flechatotalexpense),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = stringResource(R.string.total_expense),
                        style = MaterialTheme.typography.bodyMedium,
                        color = AccountBalanceLabel
                    )
                }
                Text(
                    text = "-${currencyFormatter.format(totalExpenseVal)}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = BlueButton
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            ProgressBar(
                progressPercent = progressPercentVal,
                goalAmount = currencyFormatter.format(goalTargetUsdVal)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF031314)
@Composable
private fun PreviewAccountBalanceSection() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .background(Color(0xFF031314))
                .padding(16.dp)
        ) {
            AccountBalanceSection()
        }
    }
}
