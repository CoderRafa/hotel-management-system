package com.rafengimprove.hotel.management.system.common.model.entity

import com.rafengimprove.hotel.management.system.common.model.dto.Room
import com.rafengimprove.hotel.management.system.common.model.type.*
import com.rafengimprove.hotel.management.system.common.type.*
import jakarta.persistence.*

@Entity(name = "room")
class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_sequence")
    @Column(name = "id", nullable = false)
    var roomId: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    lateinit var roomType: RoomType

    @Column(name = "room_area", nullable = false)
    var roomArea: Double = 0.0

    @Column(name = "windows", nullable = false)
    lateinit var windows: String

    @Enumerated(EnumType.STRING)
    @Column(name = "view_type", nullable = false)
    lateinit var viewType: ViewType

    @Column(name = "furniture", nullable = false)
    lateinit var furniture: String

    @Column(name = "equipment", nullable = false)
    lateinit var equipment: String

    @Column(name = "balcony", nullable = false)
    var balcony: Boolean = false
}

fun RoomEntity.toDto() = Room(
    roomId,
    roomType,
    roomArea,
    windows.convertToType { WindowType.valueOf(it) },
    viewType,
    furniture.convertToType { FurnitureType.valueOf(it) },
    equipment.convertToType { EquipmentType.valueOf(it) },
    balcony
)

fun <T> String.convertToType(delimiter: String = ",", converter: (String) -> T) =
    this.split(delimiter).map { converter(it) }
