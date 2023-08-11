package com.rafengimprove.hotel.management.system.common.model.dto

import com.rafengimprove.hotel.management.system.common.model.type.EquipmentType

data class Equipment(
    val equipmentType: EquipmentType,
    val amount: Int
)
