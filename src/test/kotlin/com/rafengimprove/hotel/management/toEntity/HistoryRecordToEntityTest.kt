package com.rafengimprove.hotel.management.toEntity

import com.rafengimprove.hotel.management.common.randomClient
import com.rafengimprove.hotel.management.common.randomService
import com.rafengimprove.hotel.management.system.model.dto.HistoryRecord
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.type.BehaviourType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class HistoryRecordToEntityTest {

    private val historyRecord = randomHistoryRecord()
    private val historyRecordEntity = historyRecord.toEntity()

    @RepeatedTest(15)
    fun `Happy pass - convert historyRecord to entity`() {
        assertEquals(historyRecord.historyRecordId, historyRecordEntity.historyRecordId)
        assertEquals(historyRecord.client, historyRecordEntity.client.toDto())
        assertEquals(historyRecord.apartmentPaymentId, historyRecordEntity.apartmentPaymentId)
        assertEquals(historyRecord.apartmentId, historyRecordEntity.apartmentId)
        assertEquals(historyRecord.behaviour, historyRecordEntity.behaviour)
        assertEquals(historyRecord.checkInDateAndTime, historyRecordEntity.checkInDateAndTime)
        assertEquals(historyRecord.checkOutDateAndTime, historyRecordEntity.checkOutDateAndTime)
        assertEquals(historyRecord.lateCheckIn, historyRecordEntity.lateCheckIn)
        assertEquals(historyRecord.lateCheckOut, historyRecordEntity.lateCheckOut)
        assertEquals(historyRecord.additionalService, historyRecordEntity.additionalService.map { it.toDto() })
    }

    private fun randomHistoryRecord() = HistoryRecord(
        nextLong(),
        randomClient(),
        nextLong(),
        nextLong(),
        BehaviourType.values().random(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        nextBoolean(),
        nextBoolean(),
        listOf(randomService())
    )
}