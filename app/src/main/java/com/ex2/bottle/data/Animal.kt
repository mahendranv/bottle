package com.ex2.bottle.data

data class Animal(
    val name: String,
    val height: Double,
    val lifeSpan: Int,
    val carnivorous: Boolean,
    val imageUrl: String? = null
)
