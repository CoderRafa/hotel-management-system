package com.rafengimprove.hotel.management.common

import com.rafengimprove.hotel.management.system.model.dto.Consumable
import kotlin.random.Random

fun randomConsumable() = Consumable(
    null,
    "Wine glass",
    Random.nextDouble(),
    Random.nextInt()
)