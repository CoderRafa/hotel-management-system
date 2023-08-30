package com.rafengimprove.hotel.management.common

import com.rafengimprove.hotel.management.system.model.dto.Position
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextLong

fun randomPosition() = Position(
    nextLong(),
    "Receptionist",
    nextDouble()
)