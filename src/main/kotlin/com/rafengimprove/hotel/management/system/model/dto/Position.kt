package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.entity.PositionEntity

data class Position(
    var positionId: Long? = null,
    val name: String,
    val baseSalary: Double
)

fun Position.toEntity() = PositionEntity().apply {
    this.positionId = this@toEntity.positionId
    this.name = this@toEntity.name
    this.baseSalary = this@toEntity.baseSalary
}
