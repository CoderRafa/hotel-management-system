package com.rafengimprove.hotel.management.system.model.entity

import com.rafengimprove.hotel.management.system.model.type.CurrencyType
import com.rafengimprove.hotel.management.system.model.type.PaymentStatusType
import com.rafengimprove.hotel.management.system.model.type.PaymentType
import com.rafengimprove.hotel.management.system.model.payment.ConsumablesPayment
import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "consumables_payment")
class ConsumablesPaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumables_payment_sequence")
    @Column(name = "id", nullable = false)
    var paymentId: Long? = null

    @Column(name = "created_date", nullable = false)
    lateinit var createdDate: LocalDate

    @Column(name = "confirmed_date", nullable = false)
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
    lateinit var status: PaymentStatusType

    @OneToMany(mappedBy = "consumable_payment")
    lateinit var consumables: List<ConsumableEntity>
}

fun ConsumablesPaymentEntity.toDto() = ConsumablesPayment(
    paymentId,
    createdDate,
    confirmedDate,
    amount,
    paymentType,
    currency,
    status,
    consumables.map { it.toDto() }
)