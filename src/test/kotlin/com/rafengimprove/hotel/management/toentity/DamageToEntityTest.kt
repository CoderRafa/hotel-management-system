package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.system.common.model.dto.Damage
import com.rafengimprove.hotel.management.system.common.model.dto.toEntity
import com.rafengimprove.hotel.management.system.common.model.type.DamageType.ROOM_DAMAGE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DamageToEntityTest {

    val damage = Damage(
        null,
        ROOM_DAMAGE,
        50.0
    )

    val damageEntity = damage.toEntity()

    @Test
    fun `Happy pass - damage toEntity works`() {
        assertEquals(damage.damageId, damageEntity.damageId)
        assertEquals(damage.damageType, damageEntity.damageType)
        assertEquals(damage.cost, damageEntity.cost)
    }
}