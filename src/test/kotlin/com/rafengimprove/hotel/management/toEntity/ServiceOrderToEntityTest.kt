package com.rafengimprove.hotel.management.toEntity

import com.rafengimprove.hotel.management.system.model.dto.ServiceOrder
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class ServiceOrderToEntityTest {

    private val serviceOrder = randomServiceOrder()
    private val serviceOrderEntity = serviceOrder.toEntity()

    @RepeatedTest(15)
    fun `Happy pass - serviceOrder toEntity works`() {
        assertEquals(serviceOrder.serviceOrderId, serviceOrderEntity.serviceOrderId)
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