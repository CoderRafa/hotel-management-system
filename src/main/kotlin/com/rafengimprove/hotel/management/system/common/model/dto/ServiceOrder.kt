package com.rafengimprove.hotel.management.system.common.model.dto

import com.rafengimprove.hotel.management.system.common.model.entity.ServiceOrderEntity
import java.time.LocalDateTime

data class ServiceOrder(
    val serviceOrderID: Long? = null,
    val clientId: Long? = null,
    val workerId: Long? = null,
    val apartmentId: Long? = null,
    val services: List<Service>,
    val serviceOrderDateTime: LocalDateTime
) {
    val cost: Double by lazy {
        services.map { it.cost }.sumOf { it }
    }
}

fun ServiceOrder.toEntity() = ServiceOrderEntity().apply {
    this.serviceOrderId = this@toEntity.serviceOrderID
    this.clientId = this@toEntity.clientId
    this.workerId = this@toEntity.workerId
    this.apartmentId = this@toEntity.apartmentId
    this.services = this@toEntity.services.map { it.toEntity() }
    this.serviceOrderDateTime = this@toEntity.serviceOrderDateTime
}
