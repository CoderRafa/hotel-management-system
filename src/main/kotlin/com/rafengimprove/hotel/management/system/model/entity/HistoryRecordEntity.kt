package com.rafengimprove.hotel.management.system.model.entity

import com.rafengimprove.hotel.management.system.model.dto.Client
import com.rafengimprove.hotel.management.system.model.dto.HistoryRecord
import com.rafengimprove.hotel.management.system.model.type.BehaviourType
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "history_record")
class HistoryRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_record_sequence")
    @Column(name = "history_record_id", nullable = false)
    var historyRecordId: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(
        JoinColumn(name = "history_record_id", referencedColumnName = "history_record_id"),
        JoinColumn(name = "client_id", referencedColumnName = "client_id")
    )
    lateinit var client: ClientEntity

    @Column(name = "apartment_payment_id", nullable = false)
    var apartmentPaymentId: Long? = null

    @Column(name = "apartment_id", nullable = false)
    var apartmentId: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "behaviour", nullable = false)
    lateinit var behaviour: BehaviourType

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

fun HistoryRecordEntity.toDto(clientDto: Client? = null) = HistoryRecord(
    historyRecordId,
    clientDto ?: client.toDto(),
    apartmentPaymentId,
    apartmentId, behaviour,
    checkInDateAndTime,
    checkOutDateAndTime,
    lateCheckIn,
    lateCheckOut,
    additionalService.map { it.toDto() }
)

