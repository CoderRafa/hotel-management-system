package com.rafengimprove.hotel.management.system.model.payment

import com.rafengimprove.hotel.management.system.common.model.type.CurrencyType
import com.rafengimprove.hotel.management.system.common.model.type.PaymentStatusType
import com.rafengimprove.hotel.management.system.common.model.type.PaymentType
import java.time.LocalDate

open class Payment(
    val paymentId: Long? = null,
    val createdDate: LocalDate,
    val confirmedDate: LocalDate,
    val amount: Double,
    val paymentType: PaymentType,
    val currency: CurrencyType,
    val status: PaymentStatusType,
)

