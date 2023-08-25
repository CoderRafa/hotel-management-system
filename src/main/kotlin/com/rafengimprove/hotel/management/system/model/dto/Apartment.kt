package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.entity.ApartmentEntity
import com.rafengimprove.hotel.management.system.model.type.RenovationType
import com.rafengimprove.hotel.management.system.model.type.ViewType


data class Apartment(
    val apartmentId: Long? = null,
    val apartmentNumber: String,
    val rooms: List<com.rafengimprove.hotel.management.system.model.dto.Room>,
    val isFurnished: Boolean,
    val isEquipped: Boolean,
    val renovationType: RenovationType,
    val isSmoking: Boolean,
    val hasWiFi: Boolean,
    val floor: Int
) {
    val hasSeaView: Boolean by lazy {
        rooms.any { it.viewType == ViewType.SEA_VIEW }
    }

    val apartmentArea: Double by lazy {
        rooms.map { it.roomArea }.sumOf { it }
    }

    val hasBalcony: Boolean by lazy {
        rooms.any { it.balcony }
    }
}

fun com.rafengimprove.hotel.management.system.model.dto.Apartment.toEntity() = ApartmentEntity().apply {
    this.apartmentId = this@toEntity.apartmentId
    this.apartmentNumber = this@toEntity.apartmentNumber
    this.rooms = this@toEntity.rooms.map(com.rafengimprove.hotel.management.system.model.dto.Room::toEntity)
    this.isFurnished = this@toEntity.isFurnished
    this.renovationType = this@toEntity.renovationType
    this.isSmoking = this@toEntity.isSmoking
    this.hasWiFi = this@toEntity.hasWiFi
    this.floor = this@toEntity.floor
    this.hasSeaView = this@toEntity.hasSeaView
    this.apartmentArea = this@toEntity.apartmentArea
    this.hasBalcony = this@toEntity.hasBalcony
    this.isEquipped = this@toEntity.isEquipped

}
