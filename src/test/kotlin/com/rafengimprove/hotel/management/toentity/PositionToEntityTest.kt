package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.system.common.model.dto.Position
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionToEntityTest {

    val position = Position(
        null,
        "Receptionist",
        900.0
    )

    val positionEntity = position.toEntity()

    @Test
    fun `Happy pass - position toEntity works`() {
        assertEquals(position.positionId, positionEntity.positionId)
        assertEquals(position.name,positionEntity.name)
        assertEquals(position.baseSalary, positionEntity.baseSalary)
    }
}