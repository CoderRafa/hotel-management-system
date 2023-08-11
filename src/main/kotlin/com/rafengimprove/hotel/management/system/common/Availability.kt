package com.rafengimprove.hotel.management.system.common

import com.rafengimprove.hotel.management.system.common.enumclasses.AvailabilityStatusType

data class Availability (
    val apartmentId: Long? = null,
    val duration: Int,
    val status: AvailabilityStatusType
)

