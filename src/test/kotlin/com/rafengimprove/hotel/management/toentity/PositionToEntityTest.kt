package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.common.randomPosition
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest

class PositionToEntityTest {

    private val position = randomPosition()

    private val positionEntity = position.toEntity()

    @RepeatedTest(15)
    fun `Happy pass - position toEntity works`() {
        assertEquals(position.positionId, positionEntity.positionId)
        assertEquals(position.name,positionEntity.name)
        assertEquals(position.baseSalary, positionEntity.baseSalary)
    }
}