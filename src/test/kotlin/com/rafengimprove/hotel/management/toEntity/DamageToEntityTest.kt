package com.rafengimprove.hotel.management.toEntity

import com.rafengimprove.hotel.management.system.model.dto.Damage
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.type.DamageType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.random.Random.Default.nextDouble

@ExtendWith(MockitoExtension::class)
class DamageToEntityTest {

    private val damage = randomDamage()
    private val damageEntity = damage.toEntity()

    @RepeatedTest(15)
    fun `Happy pass - damage toEntity works`() {
        assertEquals(damage.damageId, damageEntity.damageId)
        assertEquals(damage.damageType, damageEntity.damageType)
        assertEquals(damage.cost, damageEntity.cost)
    }

    private fun randomDamage() = Damage(
        null,
        DamageType.values().random(),
        nextDouble()
    )
}