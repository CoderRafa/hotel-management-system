package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.system.common.model.dto.Apartment
import com.rafengimprove.hotel.management.system.common.model.dto.toEntity
import com.rafengimprove.hotel.management.system.common.model.type.RenovationType.NEWLY_FURNISHED
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ApartmentToEntityTest {
    val apartment = Apartment(
        null,
        "22",
        listOf(room),
        true,
        true,
        NEWLY_FURNISHED,
        false,
        true,
        3
    )

    val apartmentEntity = apartment.toEntity()

    @Test
    fun `Happy pass - apartment toEntity works`() {
        assertEquals(apartment.apartmentId, apartmentEntity.apartmentId)
        assertEquals(apartment.apartmentNumber, apartmentEntity.apartmentNumber)
        assertEquals(apartment.rooms, apartmentEntity.rooms)
        assertEquals(apartment.isFurnished, apartmentEntity.isFurnished)
        assertEquals(apartment.isEquipped, apartmentEntity.isEquipped)
        assertEquals(apartment.renovationType, apartmentEntity.renovationType)
        assertEquals(apartment.isSmoking, apartmentEntity.isSmoking)
        assertEquals(apartment.hasWiFi, apartmentEntity.hasWiFi)
        assertEquals(apartment.floor, apartmentEntity.floor)
    }
}