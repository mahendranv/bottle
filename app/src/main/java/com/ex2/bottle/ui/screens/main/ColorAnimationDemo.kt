package com.ex2.bottle.ui.screens.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ex2.bottle.ui.theme.LIGHT_BGS

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColorAnimationDemo(navController: NavController) {

    var colorIndex by remember {
        mutableStateOf(0)
    }

    var duration by remember {
        mutableStateOf(1f)
    }

    val color by animateColorAsState(
        targetValue = LIGHT_BGS[colorIndex % LIGHT_BGS.size],
        animationSpec = TweenSpec(durationMillis = duration.toInt() * 1000)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
    ) {

        Box(
            Modifier
                .padding(24.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(color = color)
                .size(200.dp)
        ) {
            Text(
                text = "#%x".format(color.toArgb()).toUpperCase(),
                color = Color.White,
                style = MaterialTheme.typography.h6,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(24.dp)
            )
        }

        Text(
            text = "Animation speed ${duration.toInt()} seconds",
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
        )

        Slider(
            modifier = Modifier.padding(horizontal = 24.dp),
            value = duration, steps = 8, valueRange = 1f.rangeTo(10f),
            onValueChange = {
                duration = it
            },
        )

        Button(
            onClick = {
                colorIndex++
            },
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
        ) {
            Text(text = "Change color")
        }
    }
}