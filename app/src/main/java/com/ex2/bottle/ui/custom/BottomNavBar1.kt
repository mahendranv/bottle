package com.ex2.bottle.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.sharp.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val APP_BAR_HEIGHT = 56.dp
private val CIRCLE_SIZE = 6.dp
private val ICON_SIZE = 32.dp

private val COLOR_SELECTED = Color(0xffDF82AC)
private val COLOR_NORMAL = Color(0xffA6949B)

private fun Modifier.dotPlacement(
    selectedIndex: Int,
    totalItems: Int,
) =
    layout { measurable, constraints ->

        // Space is even around the icons here to compute the dot position
        // need surplus space size
        // Note: Assuming all the icons are of same width (and square)

        val circleSize = CIRCLE_SIZE.toPx()
        val iconSize = ICON_SIZE.toPx()
        val spaceBetween =
            (constraints.maxWidth - (iconSize * totalItems)) / (totalItems + 1)


        val placeable = measurable.measure(constraints)
        val placeableX =
            (selectedIndex + 1) * (iconSize + spaceBetween) - (iconSize / 2f) - circleSize / 2f
        val placeableY = iconSize + circleSize / 2f

        layout(placeable.width, placeable.height) {
            placeable.place(placeableX.toInt(), placeableY.toInt()) //ICON_SIZE.roundToPx())
        }
    }

@Composable
fun BottomAppBar1(modifier: Modifier = Modifier) {

    // Dot position in x axis
//    var dotPosition by remember { mutableStateOf(0f) }
//    val dotPositionAnimated by animateFloatAsState(targetValue = dotPosition)

    var selectedIndex by remember { mutableStateOf(4) }
    var lastIndex by remember { mutableStateOf(0) }

    Box(
        modifier = modifier
            .padding(top = 8.dp, bottom = 16.dp)
            .wrapContentHeight(Top),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .height(ICON_SIZE)
        ) {
            for ((position, icon) in BottomIconList.withIndex()) {
                BottomAppBarIcon(
                    icon,
                    modifier = Modifier
                        .size(ICON_SIZE)
                ) {
                    lastIndex = selectedIndex
                    selectedIndex = position
                }
            }
        }

        Box(
            Modifier
                .dotPlacement(selectedIndex, BottomIconList.size)
                .clip(CircleShape)
                .background(COLOR_SELECTED)
                .size(CIRCLE_SIZE)
        )
    }

}


private val BottomIconList = listOf(
    Icons.Outlined.Home,
    Icons.Outlined.Explore,
    Icons.Outlined.FavoriteBorder,
    Icons.Outlined.ShoppingBag,
    Icons.Outlined.Person,
)

@Preview(device = Devices.NEXUS_6P)
@Composable
private fun previewBottomAppbar1(

    modifier: Modifier = Modifier
) {
    Surface {
        BottomAppBar1(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun BottomAppBarIcon(
    icon: ImageVector = Icons.Sharp.Home,
    color: Color = COLOR_NORMAL,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            imageVector = icon,
            tint = color,
            contentDescription = "description",
            modifier = modifier
        )
    }
}