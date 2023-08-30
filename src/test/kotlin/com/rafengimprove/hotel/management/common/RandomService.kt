package com.rafengimprove.hotel.management.common

import com.rafengimprove.hotel.management.system.model.dto.Service
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextInt
import kotlin.random.Random.Default.nextLong

fun randomService() = Service(
    nextLong(),
    generateRandomLowerCaseLetterString(7).replaceFirstChar { it.uppercase() },
    nextDouble(),
    nextInt()
)