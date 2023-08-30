package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.system.model.dto.Consumable
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextInt

class ConsumableToEntityTest {

    private val consumable = randomConsumable()

    private val consumableEntity = consumable.toEntity()

    @RepeatedTest(15)
    fun `Happy pass - consumable toEntity works`() {
        assertEquals(consumable.consumableId, consumableEntity.consumableId)
        assertEquals(consumable.name, consumableEntity.name)
        assertEquals(consumable.cost, consumableEntity.cost)
        assertEquals(consumable.amount, consumableEntity.amount)
    }

    private fun randomConsumable() = Consumable(
        null,
        "Wine glass",
        nextDouble(),
        nextInt()
    )
}
