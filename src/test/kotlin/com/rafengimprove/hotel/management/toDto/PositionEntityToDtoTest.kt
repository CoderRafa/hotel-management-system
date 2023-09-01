package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.model.entity.PositionEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.random.Random.Default.nextDouble

@ExtendWith(MockitoExtension::class)
class PositionEntityToDtoTest {

    private val positionEntity = randomPositionEntity()
    private val position = positionEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - positionEntity toDto works`() {
        assertEquals(null, position.positionId)
        assertEquals("Receptionist", position.name)
        assertEquals(positionEntity.baseSalary, position.baseSalary)
    }

    private fun randomPositionEntity() = PositionEntity().apply {
        positionId = null
        name = "Receptionist"
        baseSalary = nextDouble()
    }
}