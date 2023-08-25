package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.common.model.entity.DamageEntity
import com.rafengimprove.hotel.management.system.common.model.entity.toDto
import com.rafengimprove.hotel.management.system.common.model.type.DamageType.ROOM_DAMAGE
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DamageEntityToDtoTest {

    val damageEntity = DamageEntity().apply {
        damageId = null
        damageType = ROOM_DAMAGE
        cost = 150.0
    }

    val damage = damageEntity.toDto()

    @Test
    fun `Happy pass - damage toDto works`() {

        assertEquals(null, damage.damageId)
        assertEquals(ROOM_DAMAGE, damage.damageType)
        assertEquals(150.0, damage.cost)
    }
}