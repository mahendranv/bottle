package com.ex2.bottle.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ex2.bottle.R


val MW = FontFamily(
    Font(R.font.mw_regular),
    Font(R.font.mw_semi_bold, FontWeight.Bold),
    Font(R.font.mw_x_light, FontWeight.ExtraLight),
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = MW,
    body1 = TextStyle(
        fontFamily = MW,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    caption = TextStyle(
        fontFamily = MW,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 12.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)