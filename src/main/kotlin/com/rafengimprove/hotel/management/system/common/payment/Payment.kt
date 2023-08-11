package com.rafengimprove.hotel.management.system.common.payment

import com.rafengimprove.hotel.management.system.common.enumclasses.CurrencyType
import com.rafengimprove.hotel.management.system.common.enumclasses.PaymentStatusType
import com.rafengimprove.hotel.management.system.common.enumclasses.PaymentType
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

