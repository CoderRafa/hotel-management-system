package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.common.randomClient
import com.rafengimprove.hotel.management.common.randomService
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.HistoryRecordEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.type.BehaviourType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class HistoryRecordEntityToDtoTest {

    private val historyRecordEntity = randomHistoryRecordEntity()
    private val historyRecord = historyRecordEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - convert history record entity to dto`() {
        assertEquals(historyRecordEntity.historyRecordId, historyRecord.historyRecordId)
        assertEquals(historyRecordEntity.client.toDto(), historyRecord.client)
        assertEquals(historyRecordEntity.apartmentPaymentId, historyRecord.apartmentPaymentId)
        assertEquals(historyRecordEntity.apartmentId, historyRecord.apartmentId)
        assertEquals(historyRecordEntity.behaviour, historyRecord.behaviour)
        assertEquals(historyRecordEntity.checkInDateAndTime, historyRecord.checkInDateAndTime)
        assertEquals(historyRecordEntity.checkOutDateAndTime, historyRecord.checkOutDateAndTime)
        assertEquals(historyRecordEntity.lateCheckIn, historyRecord.lateCheckIn)
        assertEquals(historyRecordEntity.lateCheckOut, historyRecord.lateCheckOut)
        assertEquals(historyRecordEntity.additionalService.map { it.toDto() }, historyRecord.additionalService)
    }

    private fun randomHistoryRecordEntity() = HistoryRecordEntity().apply {
        this.historyRecordId = nextLong()
        this.client = randomClient().toEntity()
        this.apartmentPaymentId = nextLong()
        this.apartmentId = nextLong()
        this.behaviour = BehaviourType.values().random()
        this.checkInDateAndTime = LocalDateTime.now()
        this.checkOutDateAndTime = LocalDateTime.now()
        this.lateCheckIn = nextBoolean()
        this.lateCheckOut = nextBoolean()
        this.additionalService = listOf(randomService().toEntity())
    }
}