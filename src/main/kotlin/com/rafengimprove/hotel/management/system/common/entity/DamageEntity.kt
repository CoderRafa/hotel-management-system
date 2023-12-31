package com.rafengimprove.hotel.management.system.common.entity

import com.rafengimprove.hotel.management.system.common.Damage
import com.rafengimprove.hotel.management.system.common.enumclasses.DamageType
import jakarta.persistence.*

@Entity(name = "damage")
class DamageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "damage_sequence")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "damage_type", nullable = false)
    lateinit var damageType: DamageType

    @Column(name = "cost", nullable = false)
    var cost: Double = 0.0
}

fun DamageEntity.toDto() = Damage(id, damageType, cost)