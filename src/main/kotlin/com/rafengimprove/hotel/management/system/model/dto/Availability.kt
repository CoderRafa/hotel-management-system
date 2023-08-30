package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.type.AvailabilityStatusType

data class Availability (
    val apartmentId: Long? = null,
    val duration: Int,
    val status: AvailabilityStatusType
)

