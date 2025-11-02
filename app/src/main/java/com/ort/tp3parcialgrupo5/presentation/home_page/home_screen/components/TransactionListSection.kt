package com.ort.tp3parcialgrupo5.presentation.home_page.home_screen.components

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
            isExpense = false
        )
        TransactionRow(
            iconRes = R.drawable.icon_groceries,
            title = stringResource(R.string.groceries),
            subtitle = stringResource(R.string.groceries_subtitle),
            category = stringResource(R.string.groceries_category),
            amount = stringResource(R.string.groceries_amount),
            isExpense = true
        )
        TransactionRow(
            iconRes = R.drawable.icon_rent,
            title = stringResource(R.string.rent),
            subtitle = stringResource(R.string.rent_subtitle),
            category = stringResource(R.string.rent_category),
            amount = stringResource(R.string.rent_amount),
            isExpense = true
        )
    }
}

@Composable
private fun TransactionRow(
    iconRes: Int,
    title: String,
    subtitle: String,
    category: String,
    amount: String,
    isExpense: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Icono
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(56.dp),
            tint = Color.Unspecified
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF5BA3D0)
            )
        }

        Box(
            modifier = Modifier
                .height(40.dp)
                .width(1.dp)
                .background(Color(0xFF1ECED5))
        )

        Box(
            modifier = Modifier.width(51.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Light,
                color = Color.White.copy(alpha = 0.8f)
            )
        }

        Box(
            modifier = Modifier
                .height(40.dp)
                .width(1.dp)
                .background(Color(0xFF1ECED5))
        )

        Text(
            text = amount,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = if (isExpense) CyanAccent else Color.White,
            modifier = Modifier.widthIn(min = 85.dp)
        )
    }
}
