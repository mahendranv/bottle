package com.ex2.bottle.data

import com.ex2.bottle.data.model.Animal
import com.github.javafaker.Faker
import java.util.*

object AppSdk {

    private val random = Random(100)
    private val faker = Faker.instance(random)

    val Animals = List(100) {
        Animal(
            name = faker.animal()!!.name().capitalize(Locale.getDefault()),
            height = random.nextDouble(),
            lifeSpan = random.nextInt(),
            carnivorous = random.nextBoolean(),
            imageUrl = faker.avatar().image(),
            description = faker.lorem().paragraph(2)
        )
    }
}