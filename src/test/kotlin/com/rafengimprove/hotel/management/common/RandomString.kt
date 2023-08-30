package com.rafengimprove.hotel.management.common

fun generateRandomLowerCaseLetterString(length: Int) : String {
    val charset = ('a'..'z')
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}

fun generateRandomUpperCaseLetterString(length: Int) : String {
    val charset = ('A'..'Z')
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}

fun generateRandomNumberString(length: Int) : String {
    val charset = ('0'..'9')
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}