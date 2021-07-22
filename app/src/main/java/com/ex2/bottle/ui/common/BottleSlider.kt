package com.ex2.bottle.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun BottleSlider(
    text: String,
    value: Float,
    range: ClosedFloatingPointRange<Float>,
    modifier: Modifier = Modifier,
    onValueChange: (Float) -> Unit,
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = text, Modifier.padding(end = 16.dp))
        Slider(value = value, valueRange = range, onValueChange = onValueChange)
    }
}