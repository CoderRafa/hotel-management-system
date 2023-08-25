package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.common.model.entity.WorkerEntity
import java.time.LocalDate

data class Worker(
    val workerId: Long? = null,
    val name: String,
    val lastname: String,
    val socialNumber: String,
    val passportNumber: String,
    val phoneNumber: String,
    val address: String,
    val email: String,
    val employmentDate: LocalDate,
    val contractTerminationDate: LocalDate,
    val position: Position,
)

fun Worker.toEntity() = WorkerEntity().apply {
    this.workerId = this@toEntity.workerId
    this.name = this@toEntity.name
    this.lastname = this@toEntity.lastname
    this.socialtNumber = this@toEntity.socialNumber
    this.passportNumber = this@toEntity.passportNumber
    this.phoneNumber = this@toEntity.phoneNumber
    this.address = this@toEntity.address
    this.email = this@toEntity.email
    this.employmentDate = this@toEntity.employmentDate
    this.contractTerminationDate = this@toEntity.contractTerminationDate
    this.position = this@toEntity.position.toEntity()
}
