package com.ex2.bottle.ui.screens.main

import androidx.annotation.IntRange
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ex2.bottle.ui.common.BottleSlider
import com.ex2.bottle.ui.common.BottleSwitch
import com.ex2.bottle.ui.common.DemoScaffold
import com.ex2.bottle.ui.theme.LIGHT_BGS


@Composable
fun ShapeAnimationDemo(navController: NavController) {
    DemoScaffold(title = "Shape animation") {
        ShapeAnimationDemoInternal()
    }
}

@Composable
private fun ShapeAnimationDemoInternal() {

    // Preference
    val sizeRange = 100f.rangeTo(200f)
    val radiusRange = 0f.rangeTo(50f)
    val componentMargin = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)

    var w by remember { mutableStateOf(100f) }
    var h by remember { mutableStateOf(100f) }
    var r by remember { mutableStateOf(0f) }
    var t by remember { mutableStateOf(1f) }


    var instant by remember { mutableStateOf(true) }
    val spec: AnimationSpec<Dp> = TweenSpec(durationMillis = if (instant) 0 else t.toInt() * 1000)
    val radiusSpec: AnimationSpec<Int> = TweenSpec(durationMillis = if (instant) 0 else t.toInt() * 1000)

    @IntRange(from = 0, to = 50)
    var radius by remember { mutableStateOf(0) }

    @IntRange(from = 100, to = 200)
    var height by remember { mutableStateOf(100) }

    @IntRange(from = 100, to = 200)
    var width by remember { mutableStateOf(100) }

    val animatedHeight by animateDpAsState(
        targetValue = height.dp,
        animationSpec = spec
    )
    val animatedWidth by animateDpAsState(targetValue = width.dp, animationSpec = spec)
    val animatedRadius by animateIntAsState(
        targetValue = radius,
        animationSpec = radiusSpec
    )

    fun applyChanges() {
        width = w.toInt()
        height = h.toInt()
        radius = r.toInt()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Shape

        item {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(animatedRadius))
                        .background(LIGHT_BGS[2])
                        .height(animatedHeight)
                        .width(animatedWidth)
                ) {

                    Text(
                        text = "${w.toInt()}X${h.toInt()} (${r.toInt()}%)",
                        color = Color.White,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.align(
                            Alignment.Center
                        )
                    )
                }
            }
        }

        item {
            BottleSwitch(
                text = "Instant apply values",
                checked = instant,
                modifier = componentMargin
            ) {
                instant = it
                applyChanges()
            }
        }

        item {
            BottleSlider(
                text = "Width",
                value = w,
                range = sizeRange,
                modifier = componentMargin
            ) {
                w = it
                if (instant) applyChanges()
            }
        }

        item {
            BottleSlider(
                text = "Height",
                value = h,
                range = sizeRange,
                modifier = componentMargin
            ) {
                h = it
                if (instant) applyChanges()
            }
        }

        item {
            BottleSlider(
                text = "Radius",
                value = r,
                range = radiusRange,
                modifier = componentMargin
            ) {
                r = it
                if (instant) applyChanges()
            }
        }

        if (!instant) {
            item {
                BottleSlider(
                    text = "Duration ${t.toInt()}s",
                    value = t,
                    range = 1f.rangeTo(5f),
                    modifier = componentMargin
                ) {
                    t = it
                }
            }

            item {
                OutlinedButton(
                    onClick = { applyChanges() },
                    modifier = componentMargin
                ) {
                    Text(text = "Apply")
                }
            }
        }
    }
}

@Preview
@Composable
fun previewShapeAnimation() {
    Surface {
        ShapeAnimationDemoInternal()
    }
}