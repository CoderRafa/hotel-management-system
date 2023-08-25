package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.system.common.model.dto.Consumable
import com.rafengimprove.hotel.management.system.common.model.dto.toEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ConsumableToEntityTest {

    val consumable = Consumable(
        null,
        "Wine glass",
        20.0,
        10
    )

    val consumableEntity = consumable.toEntity()

    @Test
    fun `Happy pass - consumable toEntity works`() {
        assertEquals(consumable.consumableId, consumableEntity.consumableId)
        assertEquals(consumable.name, consumableEntity.name)
        assertEquals(consumable.cost, consumableEntity.cost)
        assertEquals(consumable.amount, consumableEntity.amount)
    }
}
