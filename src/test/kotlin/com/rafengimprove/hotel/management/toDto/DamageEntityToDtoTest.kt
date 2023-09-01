package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.model.entity.DamageEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.type.DamageType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.random.Random.Default.nextDouble

@ExtendWith(MockitoExtension::class)
class DamageEntityToDtoTest {

    private val damageEntity = randomDamageEntity()
    private val damage = damageEntity.toDto()

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