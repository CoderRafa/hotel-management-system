package com.rafengimprove.hotel.management.system.common

import com.rafengimprove.hotel.management.system.common.entity.DamageEntity
import com.rafengimprove.hotel.management.system.common.enumclasses.DamageType

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

