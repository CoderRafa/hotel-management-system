package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.entity.ClientEntity
import com.rafengimprove.hotel.management.system.model.entity.HistoryRecordEntity
import com.rafengimprove.hotel.management.system.model.type.BehaviourType
import java.time.LocalDateTime

data class HistoryRecord(
    val historyRecordId: Long? = null,
    val client: Client,
    val apartmentPaymentId: Long? = null,
    val apartmentId: Long? = null,
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
        this.historyRecordId = this@toEntity.historyRecordId
        if(clientEntity != null) {
            this.client = clientEntity
        } else{
            this.client = this@toEntity.client.toEntity(historyRecordEntity)
        }
        this.apartmentPaymentId = this@toEntity.apartmentPaymentId
        this.apartmentId = this@toEntity.apartmentId
        this.behaviour = this@toEntity.behaviour
        this.checkInDateAndTime = this@toEntity.checkInDateAndTime
        this.checkOutDateAndTime = this@toEntity.checkOutDateAndTime
        this.lateCheckIn = this@toEntity.lateCheckIn
        this.lateCheckOut = this@toEntity.lateCheckOut
        this.additionalService = this@toEntity.additionalService.map { it.toEntity() }
    }
    return historyRecordEntity
}
