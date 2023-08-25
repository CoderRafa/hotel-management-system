package com.rafengimprove.hotel.management.system.model.entity

import com.rafengimprove.hotel.management.system.common.model.type.CurrencyType
import com.rafengimprove.hotel.management.system.common.model.type.PaymentStatusType
import com.rafengimprove.hotel.management.system.common.model.type.PaymentType
import com.rafengimprove.hotel.management.system.common.model.payment.SalaryPayment
import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "salary_payment")
class SalaryPaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salary_payment_sequence")
    @Column(name = "id", nullable = false)
    var paymentId: Long? = null

    @Column(name = "createdDate", nullable = false)
    lateinit var createdDate: LocalDate

    @Column(name = "confirmedDate", nullable = false)
    lateinit var confirmedDate: LocalDate

    @Column(name = "amount", nullable = false)
    var amount: Double = 0.0

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    lateinit var paymentType: PaymentType

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    lateinit var currency: CurrencyType

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    lateinit var paymentStatus: PaymentStatusType

    @Column(name = "bonus_amount", nullable = false)
    var bonusAmount: Double = 0.0

    @Column(name = "penalties", nullable = false)
    var penalties: Double = 0.0

    @Column(name = "worker_id", nullable = false)
    var workerId: Long? = null

}

fun SalaryPaymentEntity.toDto() = SalaryPayment(
    paymentId,
    createdDate,
    confirmedDate,
    amount,
    paymentType,
    currency,
    paymentStatus,
    bonusAmount,
    penalties,
    workerId
)