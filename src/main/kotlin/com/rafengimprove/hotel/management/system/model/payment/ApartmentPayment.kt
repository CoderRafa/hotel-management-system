package com.rafengimprove.hotel.management.system.model.payment

import com.rafengimprove.hotel.management.system.model.entity.ApartmentPaymentEntity
import com.rafengimprove.hotel.management.system.model.type.CurrencyType
import com.rafengimprove.hotel.management.system.model.type.PaymentStatusType
import com.rafengimprove.hotel.management.system.model.type.PaymentType
import java.time.LocalDate

class ApartmentPayment(
    paymentId: Long? = null,
    createdDate: LocalDate,
    confirmedDate: LocalDate,
    amount: Double,
    paymentType: PaymentType,
    currency: CurrencyType,
    status: PaymentStatusType,
    val roomId: Long? = null,
    val clientId: Long? = null
) : Payment(
    paymentId, createdDate, confirmedDate, amount, paymentType, currency, status
)

fun ApartmentPayment.toEntity() = ApartmentPaymentEntity().apply {
    this.paymentId = this@toEntity.paymentId
    this.createdDate = this@toEntity.createdDate
    this.confirmedDate = this@toEntity.confirmedDate
    this.amount = this@toEntity.amount
    this.paymentType = this@toEntity.paymentType
    this.currency = this@toEntity.currency
    this.paymentStatus = this@toEntity.status
    this.roomId = this@toEntity.roomId
    this.clientId = this@toEntity.clientId
}