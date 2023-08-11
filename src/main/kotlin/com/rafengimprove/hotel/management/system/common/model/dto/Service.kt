package com.rafengimprove.hotel.management.system.common.model.dto

import com.rafengimprove.hotel.management.system.common.model.entity.ServiceEntity

data class Service(
    var serviceId: Long? = null,
    val serviceName: String,
    val cost: Double,
    val amount: Int
)

fun Service.toEntity() = ServiceEntity().apply {
    this.serviceId = this@toEntity.serviceId
    this.serviceName = this@toEntity.serviceName
    this.cost = this@toEntity.cost
    this.amount = this@toEntity.amount
}