package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.model.entity.ConsumableEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextInt

class ConsumableEntityToDtoTest {

    val consumableEntity = randomConsumableEntity()
    val consumable = consumableEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - consumable toDto works`() {
        assertEquals(null, consumable.consumableId)
        assertEquals("Wine glass", consumable.name)
        assertEquals(consumableEntity.cost, consumable.cost)
        assertEquals(consumableEntity.amount, consumable.amount)
    }

    private fun  randomConsumableEntity() = ConsumableEntity().apply {
        consumableId = null
        name = "Wine glass"
        cost = nextDouble()
        amount = nextInt()
    }
}