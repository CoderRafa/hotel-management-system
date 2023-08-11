package com.rafengimprove.hotel.management.system.common

import com.rafengimprove.hotel.management.system.common.enumclasses.EquipmentType

data class Equipment(
    val equipmentType: EquipmentType,
    val amount: Int
)
