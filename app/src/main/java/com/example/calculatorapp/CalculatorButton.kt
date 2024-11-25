package com.example.calculatorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.nunitoFontFamily

@Composable
fun CalculatorButton (
    symbol: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val buttonBackground = when (symbol) {
        "AC", "DEL", "%", "+", "/", "x", "-", "=", "<" -> Color(0xFF4B5FFD)
        else -> Color(0xFF2F2F39)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(32.dp))
            .clickable { onClick() }
            .background(buttonBackground)
    ) {
        Text(
            text = symbol,
            fontSize = 36.sp,
            fontFamily = nunitoFontFamily,
            color = Color.White
        )
    }
}