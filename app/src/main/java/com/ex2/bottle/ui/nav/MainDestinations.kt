package com.ex2.bottle.ui.nav

import com.ex2.bottle.data.model.Demo

object MainDestinations {

    const val MainList = "main-list"

    const val ColorAnimation = "color-animation"

    const val ShapeAnimation = "shape-animation"
}

val MainDemoItems = listOf(
    Demo(
        path = MainDestinations.ColorAnimation,
        title = "Color Animation",
        description = "Animates two colors"
    ),

    Demo(
        path = MainDestinations.ShapeAnimation,
        title = "Shape Animation",
        description = "Animates dimensions"
    )
).sortedBy { it.title }