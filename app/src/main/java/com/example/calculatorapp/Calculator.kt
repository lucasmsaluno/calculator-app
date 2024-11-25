package com.example.calculatorapp

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.nunitoFontFamily

@SuppressLint("Range")
@Composable
fun Calculator (
    state: CalculatorState,
    modifier: Modifier = Modifier,
    onAction: (CalculatorActions) -> Unit
) {
    Column (
        modifier = modifier
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ) {
            Text(
                text = state.display,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = nunitoFontFamily,
                fontSize = 50.sp,
                maxLines = 5,
                lineHeight = 50.sp
            )
        }
        Column (
            modifier = Modifier
                .fillMaxHeight(5f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier.aspectRatio(2f).weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "<",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Delete)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Divide))
                    }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(7))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(8))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(9))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Multiply))
                    }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(4))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(5))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(6))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Subtract))
                    }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(1))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(2))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(3))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Add))
                    }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(0))
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier.aspectRatio(2f).weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Calculate)
                    }
                )
            }
        }
    }
}