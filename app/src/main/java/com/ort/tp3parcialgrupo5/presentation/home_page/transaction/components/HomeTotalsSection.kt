package com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R

@Composable
fun HomeTotalsSection(
    balanceLabel: String,
    balanceValue: String,
    expenseLabel: String,
    expenseValue: String,
    progressFraction: Float,
    progressTextLeft: String,
    goalPillText: String,
    note: String
) {
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.flechatotalbalance),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(balanceLabel, color = Color.White.copy(alpha = 0.75f), fontSize = 12.sp)
                }
                Text(balanceValue, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            }

            Box(Modifier.height(28.dp).width(1.dp).background(Color.White.copy(alpha = 0.25f)))

            Column(
                Modifier.weight(1f).padding(start = 16.dp),
                horizontalAlignment = Alignment.End
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.flechatotalexpense),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(expenseLabel, color = Color.White.copy(alpha = 0.75f), fontSize = 12.sp)
                }
                Text(expenseValue, color = Color(0xFF11A3FF), fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            }
        }

        Spacer(Modifier.height(12.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(progressTextLeft, color = Color.White.copy(alpha = 0.85f), fontSize = 12.sp)
            Spacer(Modifier.width(12.dp))
            Box(
                Modifier
                    .height(18.dp)
                    .weight(1f)
                    .background(Color.White.copy(alpha = 0.18f), RoundedCornerShape(999.dp))
            ) {
                Box(
                    Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(progressFraction.coerceIn(0f, 1f))
                        .align(Alignment.CenterEnd)
                        .background(Color.White, RoundedCornerShape(999.dp))
                )
            }
            Spacer(Modifier.width(12.dp))
            Surface(color = Color.White, shape = RoundedCornerShape(999.dp)) {
                Text(
                    goalPillText,
                    color = Color(0xFF2B2B2B),
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(16.dp).background(Color.White.copy(alpha = 0.35f), RoundedCornerShape(3.dp)))
            Spacer(Modifier.width(8.dp))
            Text(note, color = Color.White.copy(alpha = 0.85f), fontSize = 12.sp)
        }
    }
}