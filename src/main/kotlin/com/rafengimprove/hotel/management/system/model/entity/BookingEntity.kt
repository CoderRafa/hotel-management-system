package com.rafengimprove.hotel.management.system.model.entity

import com.rafengimprove.hotel.management.system.common.model.dto.Booking
import com.rafengimprove.hotel.management.system.common.model.type.PaymentType
import com.rafengimprove.hotel.management.system.common.model.type.SpecialRequestType
import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "booking")
class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_sequence")
    @Column(name = "id", nullable = false)
    var bookingId: Long? = null

    @OneToOne(mappedBy = "booking")
    lateinit var client: ClientEntity

    @Column(name = "check_in_date", nullable = false)
    lateinit var checkInDate: LocalDate

    @Column(name = "check_out_date", nullable = false)
    lateinit var checkOutDate: LocalDate

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name = "booking_to_client",
        joinColumns = [JoinColumn(name = "booking_id")],
        inverseJoinColumns = [JoinColumn(name = "client_id")]
    )
    lateinit var people: List<ClientEntity>

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
    client.toDto(),
    checkInDate,
    checkOutDate,
    people.map(ClientEntity::toDto),
    paymentType,
    specialRequests.convertToType { SpecialRequestType.valueOf(it) },
    promocode
)