package com.rafengimprove.hotel.management.system.common

import com.rafengimprove.hotel.management.system.common.entity.ClientEntity

data class Client(
    val clientId: Long? = null,
    val name: String,
    val lastname: String,
    val passportNumber: String,
    val phoneNumber: String,
    val email: String,
    val history: List<HistoryRecord>,
    val guestHistory: List<HistoryRecord>,
    val rating: Int
)

fun Client.toEntity() = ClientEntity().apply {
    this.clientId = this@toEntity.clientId
    this.name = this@toEntity.name
    this.lastname = this@toEntity.lastname
    this.passportNumber = this@toEntity.passportNumber
    this.phoneNumber = this@toEntity.phoneNumber
    this.email = this@toEntity.email
    this.history = this@toEntity.history.map { it.toEntity() }
}