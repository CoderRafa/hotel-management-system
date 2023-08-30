package com.rafengimprove.hotel.management.common

import com.rafengimprove.hotel.management.system.model.dto.Client
import kotlin.random.Random.Default.nextInt
import kotlin.random.Random.Default.nextLong

fun randomClient() = Client(
    nextLong(),
    generateRandomLowerCaseLetterString((4..8).random()).replaceFirstChar { it.uppercase() },
    generateRandomLowerCaseLetterString((7..12).random()).replaceFirstChar { it.uppercase() },
    "${generateRandomUpperCaseLetterString(2 )} ${generateRandomNumberString(6)}",
    generateRandomNumberString(9),
    "${generateRandomLowerCaseLetterString((7..12).random())}@gmail.com",
    mutableListOf(),
    nextInt()
)
