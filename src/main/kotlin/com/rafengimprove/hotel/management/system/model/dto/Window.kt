package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.common.model.type.WindowType

data class Window(
    val windowType: WindowType,
    val amount: Int
)
