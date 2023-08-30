package com.rafengimprove.hotel.management.system.model.entity

import com.rafengimprove.hotel.management.system.model.dto.ServiceOrder
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity(name = "service_order")
class ServiceOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_order_sequence")
    @Column(name = "id", nullable = false)
    var serviceOrderId: Long? = null

    @Column(name = "client_id", nullable = false)
    var clientId: Long? = null

    @Column(name = "worker_id", nullable = false)
    var workerId: Long? = null

    @Column(name = "apartment_id", nullable = false)
    var apartmentId: Long? = null

    @OneToMany(mappedBy = "service_order")
    lateinit var services: List<ServiceEntity>

    @Column(name = "service_order_date_time", nullable = false)
    lateinit var serviceOrderDateTime: LocalDateTime

    @Column(name = "cost", nullable = false)
    var cost: Double = 0.0
}

fun ServiceOrderEntity.toDto() = ServiceOrder(
    serviceOrderId,
    clientId,
    workerId,
    apartmentId,
    services.map { it.toDto() },
    serviceOrderDateTime,
)