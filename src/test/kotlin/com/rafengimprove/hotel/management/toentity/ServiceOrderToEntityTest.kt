package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.system.model.dto.ServiceOrder
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import java.time.LocalDateTime
import kotlin.random.Random.Default.nextLong

class ServiceOrderToEntityTest {

    private val serviceOrder = randomServiceOrder()

    private val serviceOrderEntity = serviceOrder.toEntity()

    @RepeatedTest(15)
    fun `Happy pass - serviceOrder toEntity works`() {
        assertEquals(serviceOrder.serviceOrderID, serviceOrderEntity.serviceOrderId)
        assertEquals(serviceOrder.clientId, serviceOrderEntity.clientId)
        assertEquals(serviceOrder.workerId, serviceOrderEntity.workerId)
        assertEquals(serviceOrder.apartmentId, serviceOrderEntity.apartmentId)
        assertEquals(serviceOrder.services, serviceOrderEntity.services.map { it.toDto() })
        assertEquals(serviceOrder.serviceOrderDateTime, serviceOrderEntity.serviceOrderDateTime)
    }

    private fun randomServiceOrder() = ServiceOrder(
        nextLong(),
        nextLong(),
        nextLong(),
        nextLong(),
        listOf(service),
        LocalDateTime.now()
    )
}