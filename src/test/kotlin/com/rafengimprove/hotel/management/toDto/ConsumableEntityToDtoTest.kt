package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.common.model.entity.ConsumableEntity
import com.rafengimprove.hotel.management.system.common.model.entity.toDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConsumableEntityToDtoTest {

    val consumableEntity = ConsumableEntity().apply {
        consumableId = null
        name = "Wine glass"
        cost = 10.0
        amount = 10
    }

    val consumable = consumableEntity.toDto()

    @Test
    fun `Happy pass - consumable toDto works`() {
        assertEquals(null, consumable.consumableId)
        assertEquals("Wine glass", consumable.name)
        assertEquals(10.0, consumable.cost)
        assertEquals(10, consumable.amount)
    }

}