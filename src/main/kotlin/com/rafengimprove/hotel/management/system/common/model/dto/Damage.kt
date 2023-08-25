package com.rafengimprove.hotel.management.system.common.model.dto

import com.rafengimprove.hotel.management.system.common.model.entity.DamageEntity
import com.rafengimprove.hotel.management.system.common.model.type.DamageType

data class Damage(
    var damageId: Long? = null,
    val damageType: DamageType,
    val cost: Double
)

fun Damage.toEntity() = DamageEntity().apply {
    this.damageId = this@toEntity.damageId
    this.damageType = this@toEntity.damageType
    this.cost = this@toEntity.cost
}

