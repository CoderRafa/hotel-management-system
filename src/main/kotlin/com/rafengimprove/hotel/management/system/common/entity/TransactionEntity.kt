package com.rafengimprove.hotel.management.system.common.entity

import com.rafengimprove.hotel.management.system.common.Transaction
import com.rafengimprove.hotel.management.system.common.enumclasses.CurrencyType
import com.rafengimprove.hotel.management.system.common.enumclasses.PaymentType
import com.rafengimprove.hotel.management.system.common.enumclasses.TransactionStatusType
import com.rafengimprove.hotel.management.system.common.enumclasses.TransactionType
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "transaction")
class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_sequence")
    @Column(name = "id", nullable = false)
    var transactionId: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    lateinit var transactionType: TransactionType

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    lateinit var paymentType: PaymentType

    @Column(name = "created_date_time", nullable = false)
    lateinit var createdDateTime: LocalDateTime

    @Column(name = "completed_date_time", nullable = false)
    lateinit var completedDateTime: LocalDateTime

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    lateinit var currency: CurrencyType

    @Column(name = "amount", nullable = false)
    var amount: Double = 0.0

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    lateinit var status: TransactionStatusType
}

fun TransactionEntity.toDto() = Transaction(
    transactionId,
    transactionType,
    paymentType,
    createdDateTime,
    completedDateTime,
    currency,
    amount,
    status
)