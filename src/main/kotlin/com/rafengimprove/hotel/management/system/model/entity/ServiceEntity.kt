package com.rafengimprove.hotel.management.system.model.entity

import com.rafengimprove.hotel.management.system.model.dto.Service
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "service")
class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_sequence")
    @Column(name = "id", nullable = false)
    var serviceId: Long? = null

    @Column(name = "service_name", nullable = false)
    lateinit var serviceName: String

    @Column(name = "cost", nullable = false)
    var cost: Double = 0.0

    @Column(name = "amount", nullable = false)
    var amount: Int = 0
}

fun ServiceEntity.toDto() = Service(serviceId, serviceName, cost, amount)