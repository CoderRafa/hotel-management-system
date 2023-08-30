package com.rafengimprove.hotel.management.system.model.entity

import com.rafengimprove.hotel.management.system.model.dto.Worker
import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "worker")
class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worker_sequence")
    @Column(name = "id", nullable = false)
    var workerId: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "lastname", nullable = false)
    lateinit var lastname: String

    @Column(name = "social_number", nullable = false)
    lateinit var socialNumber: String

    @Column(name = "passport_number", nullable = false)
    lateinit var passportNumber: String

    @Column(name = "phone_number", nullable = false)
    lateinit var phoneNumber: String

    @Column(name = "address", nullable = false)
    lateinit var address: String

    @Column(name = "email", nullable = false)
    lateinit var email: String

    @Column(name = "employment_date", nullable = false)
    lateinit var employmentDate: LocalDate

    @Column(name = "contract_termination_date", nullable = false)
    lateinit var contractTerminationDate: LocalDate

    @OneToOne(mappedBy = "worker")
    lateinit var position: PositionEntity
}

fun WorkerEntity.toDto() = Worker(
    workerId,
    name,
    lastname,
    socialNumber,
    passportNumber,
    phoneNumber,
    address,
    email,
    employmentDate,
    contractTerminationDate,
    position.toDto()
)