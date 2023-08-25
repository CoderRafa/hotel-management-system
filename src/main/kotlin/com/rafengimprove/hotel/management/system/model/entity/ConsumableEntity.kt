package com.rafengimprove.hotel.management.system.model.entity

import com.rafengimprove.hotel.management.system.common.model.dto.Consumable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "consumable")
class ConsumableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumable_sequence")
    @Column(name = "id", nullable = false)
    var consumableId: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "cost", nullable = false)
    var cost: Double = 0.0

    @Column(name = "amount", nullable = false)
    var amount: Int = 0
}

fun ConsumableEntity.toDto() = Consumable(consumableId, name, cost, amount)