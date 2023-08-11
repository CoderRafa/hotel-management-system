package com.rafengimprove.hotel.management.system.common.entity

import com.rafengimprove.hotel.management.system.common.Apartment
import com.rafengimprove.hotel.management.system.common.enumclasses.RenovationType
import com.rafengimprove.hotel.management.system.common.enumclasses.ViewType
import jakarta.persistence.*

@Entity(name = "apartment")
class ApartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_sequence")
    @Column(name = "id", nullable = false)
    var apartmentId: Long? = null

    @Column(name = "apartment_number", nullable = false)
    lateinit var apartmentNumber: String

    @OneToMany(mappedBy = "apartment")
    lateinit var rooms: List<RoomEntity>

    @Column(name = "is_furnished", nullable = false)
    var isFurnished: Boolean = false

    @Column(name = "is_equipped", nullable = false)
    var isEquipped: Boolean = false

    @Enumerated(EnumType.STRING)
    @Column(name = "renovation_type", nullable = false)
    lateinit var renovationType: RenovationType

    @Column(name = "is_smoking", nullable = false)
    var isSmoking: Boolean = false

    @Column(name = "has_wifi", nullable = false)
    var hasWiFi: Boolean = false

    @Column(name = "floor", nullable = false)
    var floor: Int = 1

    @Column(name = "has_sea_view", nullable = false)
    var hasSeaView: Boolean = false

    @Column(name = "apartment_area", nullable = false)
    var apartmentArea: Double = 0.0

    @Column(name = "has_balcony", nullable = false)
    var hasBalcony: Boolean = false
}

fun ApartmentEntity.toDto() = Apartment(
    apartmentId,
    apartmentNumber,
    rooms.map(RoomEntity::toDto),
    isFurnished,
    isEquipped,
    renovationType,
    isSmoking,
    hasWiFi,
    floor
)