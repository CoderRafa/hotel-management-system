package com.rafengimprove.hotel.management.system.common

import com.rafengimprove.hotel.management.system.common.entity.TransactionEntity
import com.rafengimprove.hotel.management.system.common.enumclasses.CurrencyType
import com.rafengimprove.hotel.management.system.common.enumclasses.PaymentType
import com.rafengimprove.hotel.management.system.common.enumclasses.TransactionStatusType
import com.rafengimprove.hotel.management.system.common.enumclasses.TransactionType
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


