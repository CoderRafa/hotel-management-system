package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.type.EquipmentType

data class Equipment(
    val equipmentType: EquipmentType,
    val amount: Int
)
