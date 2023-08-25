package com.rafengimprove.hotel.management.system.model.entity

import com.rafengimprove.hotel.management.system.common.model.dto.Damage
import com.rafengimprove.hotel.management.system.common.model.type.DamageType
import jakarta.persistence.*

@Entity(name = "damage")
class DamageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "damage_sequence")
    @Column(name = "id", nullable = false)
    var damageId: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "damage_type", nullable = false)
    lateinit var damageType: DamageType

    @Column(name = "cost", nullable = false)
    var cost: Double = 0.0
}

fun DamageEntity.toDto() = Damage(damageId, damageType, cost)