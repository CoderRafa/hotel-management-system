package com.rafengimprove.hotel.management.system.common.payment

import com.rafengimprove.hotel.management.system.common.Consumable
import com.rafengimprove.hotel.management.system.common.entity.ConsumableEntity
import com.rafengimprove.hotel.management.system.common.entity.ConsumablesPaymentEntity
import com.rafengimprove.hotel.management.system.common.enumclasses.CurrencyType
import com.rafengimprove.hotel.management.system.common.enumclasses.PaymentStatusType
import com.rafengimprove.hotel.management.system.common.enumclasses.PaymentType
import com.rafengimprove.hotel.management.system.common.toEntity
import java.time.LocalDate

class ConsumablesPayment(
    paymentId: Long? = null,
    createdDate: LocalDate,
    confirmedDate: LocalDate,
    amount: Double,
    paymentType: PaymentType,
    currency: CurrencyType,
    status: PaymentStatusType,
    val consumables: List<Consumable>
) : Payment(
    paymentId, createdDate, confirmedDate, amount, paymentType, currency, status
) {
}

fun ConsumablesPayment.toEntity() = ConsumablesPaymentEntity().apply {
    this.paymentId = this@toEntity.paymentId
    this.createdDate = this@toEntity.createdDate
    this.confirmedDate = this@toEntity.confirmedDate
    this.amount = this@toEntity.amount
    this.paymentType = this@toEntity.paymentType
    this.currency = this@toEntity.currency
    this.status = this@toEntity.status
    this.consumables = this@toEntity.consumables.map { it.toEntity() }
}