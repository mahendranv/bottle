package com.ex2.bottle.ui.custom

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


private val navBarItems = arrayOf(
    Icons.Outlined.Home,
    Icons.Outlined.Send,
    Icons.Outlined.FavoriteBorder,
    Icons.Outlined.PersonOutline,
)

private val COLOR_NORMAL = Color(0xffcccccc)
private val COLOR_SELECTED = Color(0xff496DE2)

private val ICON_SIZE = 24.dp

@Composable
fun BottomNavBar2(
    modifier: Modifier = Modifier,
    iconSize: Dp = ICON_SIZE,
    selectedIconScale: Float = 1.5f
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(iconSize.times(selectedIconScale))
    ) {
        for ((index, icon) in navBarItems.withIndex()) {

            AnimatableIcon(
                imageVector = icon,
                scale = if (selectedIndex == index) 1.5f else 1.0f,
                color = if (selectedIndex == index) COLOR_SELECTED else COLOR_NORMAL,
                iconSize = ICON_SIZE,
            ) {
                selectedIndex = index
            }

//            IconButton(onClick = {
//                selectedIndex = index
//            }) {
//                Icon(
//                    imageVector = icon,
//                    contentDescription = "dummy",
//                    modifier = Modifier
//                        .scale(if (selectedIndex == index) 1.5f else 1.0f)
//                        .size(iconSize),
//                    tint = if (selectedIndex == index) COLOR_SELECTED else COLOR_NORMAL
//                )
//            }
        }
    }
}

@Composable
fun AnimatableIcon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    iconSize: Dp = ICON_SIZE,
    scale: Float = 1f,
    color: Color = COLOR_NORMAL,
    onClick: () -> Unit
) {
    // Animation params
    val animatedScale: Float by animateFloatAsState(
        targetValue = scale,
        animationSpec = TweenSpec(
            durationMillis = 2000,
            easing = FastOutSlowInEasing
        )
    )
    val animatedColor by animateColorAsState(
        targetValue = color,
        animationSpec = TweenSpec(
            durationMillis = 2000,
            easing = FastOutSlowInEasing
        )
    )

    IconButton(
        onClick = onClick,
        modifier = modifier.size(iconSize)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "dummy",
            tint = animatedColor,
            modifier = modifier.scale(animatedScale)
        )
    }
}

@Preview(group = "Icon", name = "Icon design")
@Composable
fun previewIcon() {
    Surface {

        var selected by remember {
            mutableStateOf(false)
        }

        AnimatableIcon(
            imageVector = Icons.Outlined.FavoriteBorder,
            scale = if (selected) 1.5f else 1f,
            color = if (selected) COLOR_SELECTED else COLOR_NORMAL,
            iconSize = 56.dp,
            modifier = Modifier.padding(8.dp)
        ) {
            selected = !selected
        }
    }
}


@Preview(group = "Main", name = "Bottom bar - animated")
@Composable
fun previewBottomNavBar2() {
    Surface {
        BottomNavBar2()
    }
}