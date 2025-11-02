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
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.CyanAccent
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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
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
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                    )
                }
                Text(
                    text = currencyFormatter.format(totalBalanceVal),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.25f))
            )

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
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
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                    )
                }
                Text(
                    text = "-${currencyFormatter.format(totalExpenseVal)}",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = CyanAccent
                )
            }
        }

        ProgressBar(
            progressPercent = progressPercentVal,
            goalAmount = currencyFormatter.format(goalTargetUsdVal)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.check),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = Color.Unspecified
            )
            Spacer(Modifier.width(6.dp))
            Text(
                text = stringResource(R.string.expense_looks_good),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
            )
        }
    }
}
