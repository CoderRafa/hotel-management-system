package com.rafengimprove.hotel.management.system.common.model.dto

import com.rafengimprove.hotel.management.system.common.model.entity.ClientEntity
import com.rafengimprove.hotel.management.system.common.model.entity.HistoryRecordEntity

data class Client(
    val clientId: Long? = null,
    val name: String,
    val lastname: String,
    val passportNumber: String,
    val phoneNumber: String,
    val email: String,
    val history: MutableList<HistoryRecord>,
    val guestHistory: MutableList<HistoryRecord>,
    val rating: Int
)

fun Client.toEntity(historyRecordEntity: HistoryRecordEntity? = null): ClientEntity {
    val clientEntity = ClientEntity()
    clientEntity.apply {
        this.clientId = this@toEntity.clientId
        this.name = this@toEntity.name
        this.lastname = this@toEntity.lastname
        this.passportNumber = this@toEntity.passportNumber
        this.phoneNumber = this@toEntity.phoneNumber
        this.email = this@toEntity.email
        this.history = if (historyRecordEntity != null) {
            this@toEntity.history.map { it.toEntity(clientEntity) }
        } else {
            this@toEntity.history.map { it.toEntity() }
        }
    }
    return clientEntity
}