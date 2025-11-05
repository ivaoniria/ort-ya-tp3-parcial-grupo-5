package com.ort.tp3parcialgrupo5.presentation.home_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.ui.theme.BackgroundListContainer
import com.ort.tp3parcialgrupo5.ui.theme.CarIconBlue
import com.ort.tp3parcialgrupo5.ui.theme.FinButtonText
import com.ort.tp3parcialgrupo5.ui.theme.FinWhite
import com.ort.tp3parcialgrupo5.ui.theme.SummaryGreen
import com.ort.tp3parcialgrupo5.ui.theme.SummarySubtitleTextDark
import com.ort.tp3parcialgrupo5.ui.theme.UnspecifiedColor

@Composable
fun SummarySection(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(containerColor = SummaryGreen),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(x = (-15).dp)
                .padding(start = 10.dp, end = 26.dp, top = 18.dp, bottom = 18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Box(
                    modifier = Modifier.weight(0.5f),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier.size(72.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Canvas(modifier = Modifier.matchParentSize()) {
                                val stroke = 4.dp.toPx()
                                drawCircle(color = CarIconBlue, style = Stroke(stroke))
                                drawArc(
                                    color = CarIconBlue,
                                    startAngle = 270f,
                                    sweepAngle = 180f,
                                    useCenter = false,
                                    style = Stroke(stroke)
                                )
                                drawArc(
                                    color = FinWhite,
                                    startAngle = 90f,
                                    sweepAngle = 180f,
                                    useCenter = false,
                                    style = Stroke(stroke)
                                )
                            }
                            Icon(
                                painter = painterResource(R.drawable.car),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp),
                                tint = UnspecifiedColor
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = stringResource(R.string.on_goals),
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.SemiBold,
                            color = SummarySubtitleTextDark,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Box(
                    modifier = Modifier.weight(0.5f),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.salary),
                                contentDescription = null,
                                modifier = Modifier.size(width = 31.dp, height = 28.dp),
                                tint = UnspecifiedColor
                            )
                            Column(horizontalAlignment = Alignment.Start) {
                                Text(
                                    text = stringResource(R.string.revenue_last_week),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = SummarySubtitleTextDark
                                )
                                Text(
                                    text = stringResource(R.string.savings),
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = FinButtonText
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(3.dp)
                                .background(Color.White.copy(alpha = 0.6f))
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.food),
                                contentDescription = null,
                                modifier = Modifier.size(width = 31.dp, height = 28.dp),
                                tint = Color.Unspecified
                            )
                            Column(horizontalAlignment = Alignment.Start) {
                                Text(
                                    text = stringResource(R.string.food_last_week),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = SummarySubtitleTextDark
                                )
                                Text(
                                    text = stringResource(R.string.food_last_week_amount),
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = CarIconBlue
                                )
                            }
                        }
                    }
                }
            }
            // Linea Central
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(x = (-15).dp)
                    .width(2.dp)
                    .height(108.dp)
                    .background(FinWhite)
                    .zIndex(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSummarySection() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundListContainer)
                .padding(16.dp)
        ) {
            SummarySection()
        }
    }
}
