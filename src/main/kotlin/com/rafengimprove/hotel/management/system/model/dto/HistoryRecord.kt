package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.entity.ClientEntity
import com.rafengimprove.hotel.management.system.model.entity.HistoryRecordEntity
import com.rafengimprove.hotel.management.system.model.type.BehaviourType
import java.time.LocalDateTime

data class HistoryRecord(
    val historyRecordID: Long? = null,
    val client: Client,
    val apartmentPaymentID: Long? = null,
    val apartmentID: Long? = null,
    val behaviour: BehaviourType,
    val checkInDateAndTime: LocalDateTime,
    val checkOutDateAndTime: LocalDateTime,
    val lateCheckIn: Boolean,
    val lateCheckOut: Boolean,
    val additionalService: List<Service>
)

fun HistoryRecord.toEntity(clientEntity: ClientEntity? = null): HistoryRecordEntity {
    val historyRecordEntity = HistoryRecordEntity()
    historyRecordEntity.apply {
        this.historyRecordId = this@toEntity.historyRecordID
        if(clientEntity != null) {
            this.client = clientEntity
        } else{
            this.client = this@toEntity.client.toEntity(historyRecordEntity)
        }
        this.apartmentPaymentId = this@toEntity.apartmentPaymentID
        this.apartmentId = this@toEntity.apartmentID
        this.behaviour = this@toEntity.behaviour
        this.checkInDateAndTime = this@toEntity.checkInDateAndTime
        this.checkOutDateAndTime = this@toEntity.checkOutDateAndTime
        this.lateCheckIn = this@toEntity.lateCheckIn
        this.lateCheckOut = this@toEntity.lateCheckOut
        this.additionalService = this@toEntity.additionalService.map { it.toEntity() }
    }
    return historyRecordEntity
}
