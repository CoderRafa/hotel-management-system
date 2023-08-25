package com.rafengimprove.hotel.management.common

import com.rafengimprove.hotel.management.system.common.model.dto.Room
import com.rafengimprove.hotel.management.system.common.model.type.*
import kotlin.random.Random

fun randomRoom() = Room(
    Random.nextLong(),
    RoomType.BEDROOM,
    Random.nextDouble(),
    listOf(WindowType.FIXED_WINDOW),
    ViewType.SEA_VIEW,
    listOf(FurnitureType.DOUBLE_BED),
    listOf(EquipmentType.TV),
    Random.nextBoolean()
)