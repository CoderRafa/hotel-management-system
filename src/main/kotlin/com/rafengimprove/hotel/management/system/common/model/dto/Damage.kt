package com.rafengimprove.hotel.management.system.common.model.dto

import com.rafengimprove.hotel.management.system.common.model.entity.DamageEntity
import com.rafengimprove.hotel.management.system.common.model.type.DamageType

data class Damage(
    var damageID: Long? = null,
    val damageType: DamageType,
    val cost: Double
)

fun Damage.tEntity() = DamageEntity().apply {
    this.id = this@tEntity.damageID
    this.damageType = this@tEntity.damageType
    this.cost = this@tEntity.cost
}

