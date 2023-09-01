package com.rafengimprove.hotel.management.toEntity

import com.rafengimprove.hotel.management.common.randomRoom
import com.rafengimprove.hotel.management.system.model.dto.Apartment
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.type.RenovationType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextInt

@ExtendWith(MockitoExtension::class)
class ApartmentToEntityTest {

    private val apartment = randomApartment()
    private val apartmentEntity = apartment.toEntity()

    @RepeatedTest(15)
    internal fun `Happy pass - apartment toEntity works`() {
        assertEquals(apartment.apartmentId, apartmentEntity.apartmentId)
        assertEquals(apartment.apartmentNumber, apartmentEntity.apartmentNumber)
        assertEquals(apartment.rooms, apartmentEntity.rooms.map { it.toDto() })
        assertEquals(apartment.isFurnished, apartmentEntity.isFurnished)
        assertEquals(apartment.isEquipped, apartmentEntity.isEquipped)
        assertEquals(apartment.renovationType, apartmentEntity.renovationType)
        assertEquals(apartment.isSmoking, apartmentEntity.isSmoking)
        assertEquals(apartment.hasWiFi, apartmentEntity.hasWiFi)
        assertEquals(apartment.floor, apartmentEntity.floor)
    }

    private fun randomApartment() = Apartment(
        null,
        "${nextInt(1, 33)}",
        listOf(randomRoom()),
        nextBoolean(),
        nextBoolean(),
        RenovationType.values().random(),
        nextBoolean(),
        nextBoolean(),
        nextInt(1, 7)
    )
}