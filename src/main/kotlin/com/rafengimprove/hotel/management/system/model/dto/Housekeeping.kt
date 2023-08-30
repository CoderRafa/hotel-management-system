package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.type.CleaningStatusType
import java.time.LocalDateTime

data class Housekeeping (
    val date: LocalDateTime,
    val worker: Worker,
    val apartmentNumber: Int,
    val cleaningStatus: CleaningStatusType
)

