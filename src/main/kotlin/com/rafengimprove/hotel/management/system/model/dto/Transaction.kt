package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.entity.TransactionEntity
import com.rafengimprove.hotel.management.system.model.type.CurrencyType
import com.rafengimprove.hotel.management.system.model.type.PaymentType
import com.rafengimprove.hotel.management.system.model.type.TransactionStatusType
import com.rafengimprove.hotel.management.system.model.type.TransactionType
import java.time.LocalDateTime

data class Transaction(
    val transactionId: Long? = null,
    val transactionType: TransactionType,
    val paymentType: PaymentType,
    val createdDateTime: LocalDateTime,
    val completedDateTime: LocalDateTime,
    val currency: CurrencyType,
    val amount: Double,
    val status: TransactionStatusType
)

fun Transaction.toEntity() = TransactionEntity().apply {
    this.transactionId = this@toEntity.transactionId
    this.transactionType = this@toEntity.transactionType
    this.paymentType = this@toEntity.paymentType
    this.createdDateTime = this@toEntity.createdDateTime
    this.completedDateTime = this@toEntity.completedDateTime
    this.currency = this@toEntity.currency
    this.amount = this@toEntity.amount
    this.status = this@toEntity.status
}


