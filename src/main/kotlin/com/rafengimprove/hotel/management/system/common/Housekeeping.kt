package com.rafengimprove.hotel.management.system.common

import com.rafengimprove.hotel.management.system.common.enumclasses.CleaningStatusType
import java.time.LocalDateTime

data class Housekeeping (
    val date: LocalDateTime,
    val worker: Worker,
    val apartmentNumber: Int,
    val cleaningStatus: CleaningStatusType
)

