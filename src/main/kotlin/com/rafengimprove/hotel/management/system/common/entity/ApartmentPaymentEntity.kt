package com.rafengimprove.hotel.management.system.common.entity

import com.rafengimprove.hotel.management.system.common.enumclasses.CurrencyType
import com.rafengimprove.hotel.management.system.common.enumclasses.PaymentStatusType
import com.rafengimprove.hotel.management.system.common.enumclasses.PaymentType
import com.rafengimprove.hotel.management.system.common.payment.ApartmentPayment
import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "apartment_payment")
class ApartmentPaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_payment_sequence")
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

    @Column(name = "room_id", nullable = false)
    var roomId: Long? = null

    @Column(name = "client_id", nullable = false)
    var clientId: Long? = null

}

fun ApartmentPaymentEntity.toDto() = ApartmentPayment(
    paymentId,
    createdDate,
    confirmedDate,
    amount,
    paymentType,
    currency,
    paymentStatus,
    roomId,
    clientId
)