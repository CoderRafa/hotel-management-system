package com.rafengimprove.hotel.management.system.common

import com.rafengimprove.hotel.management.system.common.entity.ApartmentEntity
import com.rafengimprove.hotel.management.system.common.enumclasses.RenovationType
import com.rafengimprove.hotel.management.system.common.enumclasses.ViewType.SEA_VIEW

data class Apartment(
    val apartmentId: Long? = null,
    val apartmentNumber: String,
    val rooms: List<Room>,
    val isFurnished: Boolean,
    val isEquipped: Boolean,
    val renovationType: RenovationType,
    val isSmoking: Boolean,
    val hasWiFi: Boolean,
    val floor: Int
) {
    val hasSeaView: Boolean by lazy {
        rooms.any { it.viewType == SEA_VIEW }
    }

    val apartmentArea: Double by lazy {
        rooms.map { it.roomArea }.sumOf { it }
    }

    val hasBalcony: Boolean by lazy {
        rooms.any { it.balcony }
    }
}

fun Apartment.toEntity() = ApartmentEntity().apply {
    this.apartmentId = this@toEntity.apartmentId
    this.apartmentNumber = this@toEntity.apartmentNumber
    this.rooms = this@toEntity.rooms.map(Room::toEntity)
    this.isFurnished = this@toEntity.isFurnished
    this.renovationType = this@toEntity.renovationType
    this.isSmoking = this@toEntity.isSmoking
    this.hasWiFi = this@toEntity.hasWiFi
    this.floor = this@toEntity.floor
    this.hasSeaView = this@toEntity.hasSeaView
    this.apartmentArea = this@toEntity.apartmentArea
    this.hasBalcony = this@toEntity.hasBalcony

}
