package com.rafengimprove.hotel.management.system.common.model.entity

import com.rafengimprove.hotel.management.system.common.model.dto.Position
import jakarta.persistence.*

@Entity(name = "position")
class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_sequence")
    @Column(name = "id", nullable = false)
    var positionId: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "base_salary", nullable = false)
    var baseSalary: Double = 0.0
}

fun PositionEntity.toDto() = Position(positionId, name, baseSalary)