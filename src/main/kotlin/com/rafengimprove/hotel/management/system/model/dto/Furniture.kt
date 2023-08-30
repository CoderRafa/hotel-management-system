package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.type.FurnitureType

data class Furniture(
    val furnitureType: FurnitureType,
    val amount: Int
)
