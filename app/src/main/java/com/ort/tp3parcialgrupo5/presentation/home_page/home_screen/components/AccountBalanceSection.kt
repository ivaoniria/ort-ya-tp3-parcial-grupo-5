package com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    val totalBalanceVal = parseNumber(stringResource(R.string.total_balance_value))      // "7783.00"
    val totalExpenseVal = parseNumber(stringResource(R.string.total_expense_value))      // "1187.40"
    val progressPercentVal = stringResource(R.string.progress_percent_value).trim().toIntOrNull() ?: 0 // "30"
    val goalTargetUsdVal = parseNumber(stringResource(R.string.goal_target_usd_value))   // "20000"

    val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US).apply {
        maximumFractionDigits = 2
        minimumFractionDigits = 2
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = stringResource(R.string.total_balance),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                )
                Text(
                    text = currencyFormatter.format(totalBalanceVal),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = stringResource(R.string.total_expense),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                )
                Text(
                    text = "-${currencyFormatter.format(totalExpenseVal)}",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = CyanAccent
                )
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${progressPercentVal}%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        text = currencyFormatter.format(goalTargetUsdVal),
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = CyanAccent,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            LinearProgressIndicator(
                progress = { progressPercentVal / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(50)),
                color = Color.White,
                trackColor = Color.White.copy(alpha = 0.25f)
            )
        }

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
            Text(
                text = stringResource(R.string.expense_looks_good),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                modifier = Modifier.padding(start = 6.dp)
            )
        }
    }
}
