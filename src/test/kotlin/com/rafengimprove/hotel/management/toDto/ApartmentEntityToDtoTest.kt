package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.common.generateRandomNumberString
import com.rafengimprove.hotel.management.common.randomRoom
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.ApartmentEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.type.RenovationType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextInt
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class ApartmentEntityToDtoTest {

    private val apartmentEntity = randomApartmentEntity()
    private val apartment = apartmentEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - convert apartment entity to dto`() {

        assertEquals(apartmentEntity.apartmentId, apartment.apartmentId)
        assertEquals(apartmentEntity.apartmentNumber, apartment.apartmentNumber)
        assertEquals(apartmentEntity.rooms.map { it.toDto() }, apartment.rooms)
        assertEquals(apartmentEntity.isFurnished, apartment.isFurnished)
        assertEquals(apartmentEntity.isEquipped, apartment.isEquipped)
        assertEquals(apartmentEntity.renovationType, apartment.renovationType)
        assertEquals(apartmentEntity.isSmoking, apartment.isSmoking)
        assertEquals(apartmentEntity.hasWiFi, apartment.hasWiFi)
        assertEquals(apartmentEntity.floor, apartment.floor)
    }

    private fun randomApartmentEntity() = ApartmentEntity().apply {
        this.apartmentId = nextLong()
        this.apartmentNumber = generateRandomNumberString(3)
        this.rooms = listOf(randomRoom().toEntity())
        this.isFurnished = nextBoolean()
        this.isEquipped = nextBoolean()
        this.renovationType = RenovationType.values().random()
        this.isSmoking = nextBoolean()
        this.hasWiFi = nextBoolean()
        this.floor = nextInt()
    }
}