package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.common.model.entity.PositionEntity
import com.rafengimprove.hotel.management.system.common.model.entity.toDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionEntityToDtoTest {

    val positionEntity = PositionEntity().apply {
        positionId = null
        name = "Receptionist"
        baseSalary = 900.0
    }

    val position = positionEntity.toDto()

    @Test
    fun `Happy pass - positionEntity toDto works`() {
        assertEquals(null, position.positionId)
        assertEquals("Receptionist", position.name)
        assertEquals(900.0, position.baseSalary)
    }
}