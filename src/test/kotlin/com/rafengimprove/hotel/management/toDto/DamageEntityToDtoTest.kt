package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.model.entity.DamageEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.type.DamageType
import com.rafengimprove.hotel.management.system.model.type.DamageType.ROOM_DAMAGE
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import kotlin.random.Random.Default.nextDouble

class DamageEntityToDtoTest {

    val damageEntity = randomDamageEntity()

    val damage = damageEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - damage toDto works`() {

        assertEquals(null, damage.damageId)
        assertEquals(damageEntity.damageType, damage.damageType)
        assertEquals(damageEntity.cost, damage.cost)
    }

    private fun randomDamageEntity() = DamageEntity().apply {
        damageId = null
        damageType = DamageType.values().random()
        cost = nextDouble()
    }
}