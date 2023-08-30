package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.entity.RoomEntity
import com.rafengimprove.hotel.management.system.model.type.*

data class Room (
    var roomId: Long? = null,
    val roomType: RoomType,
    val roomArea: Double,
    val windows: List<WindowType>,
    val viewType: ViewType,
    val furniture: List<FurnitureType>,
    val equipment: List<EquipmentType>,
    val balcony: Boolean
)

fun Room.toEntity() = RoomEntity().apply {
    this.roomId = this@toEntity.roomId
    this.roomType = this@toEntity.roomType
    this.roomArea = this@toEntity.roomArea
    this.windows = this@toEntity.windows.sorted().joinToString(separator = ",")
    this.viewType = this@toEntity.viewType
    this.furniture = this@toEntity.furniture.sorted().joinToString(separator = ",")
    this.equipment = this@toEntity.equipment.sorted().joinToString(separator = ",")
    this.balcony = this@toEntity.balcony
}

