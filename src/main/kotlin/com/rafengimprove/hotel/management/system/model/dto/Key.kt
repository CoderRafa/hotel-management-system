package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.type.KeyStatusType
import java.time.LocalDate

data class Key(
    val keiID: Long? = null,
    val apartmentID: Long? = null,
    val issueDate: LocalDate,
    val expirationDate: LocalDate,
    val status: List<KeyStatusType>
)
