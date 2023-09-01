package com.rafengimprove.hotel.management.toEntity

import com.rafengimprove.hotel.management.common.randomConsumable
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
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


}
