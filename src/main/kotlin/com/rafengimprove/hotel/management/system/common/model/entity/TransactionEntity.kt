package com.rafengimprove.hotel.management.system.common.model.entity

import com.rafengimprove.hotel.management.system.common.model.dto.Transaction
import com.rafengimprove.hotel.management.system.common.model.type.CurrencyType
import com.rafengimprove.hotel.management.system.common.model.type.PaymentType
import com.rafengimprove.hotel.management.system.common.model.type.TransactionStatusType
import com.rafengimprove.hotel.management.system.common.model.type.TransactionType
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