package com.rafengimprove.hotel.management.system.common.model.payment

import com.rafengimprove.hotel.management.system.common.model.entity.SalaryPaymentEntity
import com.rafengimprove.hotel.management.system.common.model.type.CurrencyType
import com.rafengimprove.hotel.management.system.common.model.type.PaymentStatusType
import com.rafengimprove.hotel.management.system.common.model.type.PaymentType
import java.time.LocalDate

class SalaryPayment(
    paymentId: Long? = null,
    createdDate: LocalDate,
    confirmedDate: LocalDate,
    amount: Double,
    paymentType: PaymentType,
    currency: CurrencyType,
    status: PaymentStatusType,
    val bonusAmount: Double,
    val penalties: Double,
    val workerID: Long? = null,
) : Payment(
    paymentId, createdDate, confirmedDate, amount, paymentType, currency, status
) {
}

fun SalaryPayment.toEntity() = SalaryPaymentEntity().apply {
    this.paymentId = this@toEntity.paymentId
    this.createdDate = this@toEntity.createdDate
    this.confirmedDate = this@toEntity.confirmedDate
    this.amount = this@toEntity.amount
    this.paymentType = this@toEntity.paymentType
    this.currency = this@toEntity.currency
    this.paymentStatus = this@toEntity.status
    this.bonusAmount = this@toEntity.bonusAmount
    this.penalties = this@toEntity.penalties
    this.workerId = this@toEntity.workerID
}

