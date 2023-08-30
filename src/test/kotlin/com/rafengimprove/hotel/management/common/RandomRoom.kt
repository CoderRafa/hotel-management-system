package com.rafengimprove.hotel.management.common

import com.rafengimprove.hotel.management.system.model.dto.Room
import com.rafengimprove.hotel.management.system.model.type.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextLong

fun randomRoom() = Room(
    nextLong(),
    RoomType.values().random(),
    nextDouble(),
    listOf(WindowType.values().random()),
    ViewType.values().random(),
    listOf(FurnitureType.values().random()),
    listOf(EquipmentType.values().random()),
    Random.nextBoolean()
)