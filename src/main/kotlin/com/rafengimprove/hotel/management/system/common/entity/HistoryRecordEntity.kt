package com.rafengimprove.hotel.management.system.common.entity

import com.rafengimprove.hotel.management.system.common.Client
import com.rafengimprove.hotel.management.system.common.HistoryRecord
import com.rafengimprove.hotel.management.system.common.enumclasses.BehaviourType
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "history_record")
class HistoryRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_record_sequence")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(
        JoinColumn(name = "history_record_id", referencedColumnName = "id"),
        JoinColumn(name = "client", referencedColumnName = "client")
    )
    lateinit var client: ClientEntity

    @Column(name = "apartment_payment_id", nullable = false)
    var apartmentPaymentId: Long? = null

    @Column(name = "apartment_id", nullable = false)
    var apartmentId: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "behaviour", nullable = false)
    lateinit var behaviour: BehaviourType

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "history_record_to_client",
        joinColumns = [JoinColumn(name = "history_record_id")],
        inverseJoinColumns = [JoinColumn(name = "client_id")]
    )
    lateinit var people: List<ClientEntity>

    @Column(name = "check_in_date_and_time", nullable = false)
    lateinit var checkInDateAndTime: LocalDateTime

    @Column(name = "check_out_date_and_time", nullable = false)
    lateinit var checkOutDateAndTime: LocalDateTime

    @Column(name = "late_check_in", nullable = false)
    var lateCheckIn: Boolean = false

    @Column(name = "late_check_out", nullable = false)
    var lateCheckOut: Boolean = false

    @OneToMany(mappedBy = "history_record")
    lateinit var additionalService: List<ServiceEntity>
}

fun HistoryRecordEntity.toDto() = HistoryRecord(
    id,
    client.toDto(),
    apartmentPaymentId,
    apartmentId, behaviour,
    people.map { it.toDto() },
    checkInDateAndTime,
    checkOutDateAndTime,
    lateCheckIn,
    lateCheckOut,
    additionalService.map { it.toDto() }
)

