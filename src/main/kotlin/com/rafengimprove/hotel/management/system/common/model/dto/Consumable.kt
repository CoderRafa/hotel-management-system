package com.rafengimprove.hotel.management.system.common.model.dto

import com.rafengimprove.hotel.management.system.common.model.entity.ConsumableEntity

data class Consumable(
    val consumableId: Long? = null,
    val name: String,
    val cost: Double,
    val amount: Int
)

fun Consumable.toEntity() = ConsumableEntity().apply {
    this.consumableId == this@toEntity.consumableId
    this.name = this@toEntity.name
    this.cost = this@toEntity.cost
    this.amount = this@toEntity.amount
}
