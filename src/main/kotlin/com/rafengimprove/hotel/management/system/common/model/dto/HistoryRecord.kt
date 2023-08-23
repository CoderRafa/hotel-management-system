package com.rafengimprove.hotel.management.system.common.model.dto

import com.rafengimprove.hotel.management.system.common.model.entity.ClientEntity
import com.rafengimprove.hotel.management.system.common.model.entity.HistoryRecordEntity
import com.rafengimprove.hotel.management.system.common.model.type.BehaviourType
import java.time.LocalDateTime

data class HistoryRecord(
    val historyRecordID: Long? = null,
    val client: Client,
    val apartmentPaymentID: Long? = null,
    val apartmentID: Long? = null,
    val behaviour: BehaviourType,
    val people: List<Client>,
    val checkInDateAndTime: LocalDateTime,
    val checkOutDateAndTime: LocalDateTime,
    val lateCheckIn: Boolean,
    val lateCheckOut: Boolean,
    val additionalService: List<Service>
)

fun HistoryRecord.toEntity(clientEntity: ClientEntity?) = HistoryRecordEntity().apply {
    this.historyRecordId = this@toEntity.historyRecordID
    if(client != null) {
        this.client = clientEntity!!
    }else{
        this.client = this@toEntity.client.toEntity()
    }
    this.apartmentPaymentId = this@toEntity.apartmentPaymentID
    this.apartmentId = this@toEntity.apartmentID
    this.behaviour = this@toEntity.behaviour
    this.people = this@toEntity.people.map { it.toEntity() }
    this.checkInDateAndTime = this@toEntity.checkInDateAndTime
    this.checkOutDateAndTime = this@toEntity.checkOutDateAndTime
    this.lateCheckIn = this@toEntity.lateCheckIn
    this.lateCheckOut = this@toEntity.lateCheckOut
    this.additionalService = this@toEntity.additionalService.map { it.toEntity() }
}
