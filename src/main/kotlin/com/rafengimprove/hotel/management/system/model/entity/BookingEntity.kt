package com.rafengimprove.hotel.management.system.model.entity

import com.rafengimprove.hotel.management.system.model.dto.Booking
import com.rafengimprove.hotel.management.system.model.type.PaymentType
import com.rafengimprove.hotel.management.system.model.type.SpecialRequestType
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "booking")
class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_sequence")
    @Column(name = "id", nullable = false)
    var bookingId: Long? = null

    @Column(name = "apartmentId")
    var apartmentId: Long? = null

    @OneToOne(mappedBy = "booking")
    lateinit var client: ClientEntity

    @Column(name = "check_in_date", nullable = false)
    lateinit var checkInDate: LocalDateTime

    @Column(name = "check_out_date", nullable = false)
    lateinit var checkOutDate: LocalDateTime

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    lateinit var paymentType: PaymentType

    @Column(name = "special_request", nullable = false)
    lateinit var specialRequests: String

    @Column(name = "promocode", nullable = true)
    lateinit var promocode: String
}

fun BookingEntity.toDto() = Booking(
    bookingId,
    apartmentId,
    client.toDto(),
    checkInDate,
    checkOutDate,
    paymentType,
    specialRequests.convertToType { SpecialRequestType.valueOf(it) },
    promocode
)