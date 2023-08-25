package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.system.common.model.dto.ServiceOrder
import com.rafengimprove.hotel.management.system.common.model.dto.toEntity
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class ServiceOrderToEntityTest {

    val serviceOrder = ServiceOrder(
        null,
        null,
        null,
        null,
        listOf(service),
        LocalDateTime.now()
    )

    val serviceOrderEntity = serviceOrder.toEntity()

    @Test
    fun `Happy pass - serviceOrder toEntity works`() {
        assertEquals(serviceOrder.serviceOrderID, serviceOrderEntity.serviceOrderId)
        assertEquals(serviceOrder.clientId, serviceOrderEntity.clientId)
        assertEquals(serviceOrder.workerId, serviceOrderEntity.workerId)
        assertEquals(serviceOrder.apartmentId, serviceOrderEntity.apartmentId)
        assertEquals(serviceOrder.services, serviceOrderEntity.services)
        assertEquals(serviceOrder.serviceOrderDateTime, serviceOrderEntity.serviceOrderDateTime)
    }
}