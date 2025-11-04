package com.ort.tp3parcialgrupo5.presentation.home_page.transaction.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.tp3parcialgrupo5.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MonthHeader(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        textAlign = TextAlign.Start
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF121212)
@Composable
fun MonthHeaderPreview() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFF121212))
        .padding(16.dp)) {
        MonthHeader(text = "November 2025")
    }
}