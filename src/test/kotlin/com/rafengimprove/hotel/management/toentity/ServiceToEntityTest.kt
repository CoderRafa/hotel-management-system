package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.system.common.model.dto.Service
import com.rafengimprove.hotel.management.system.common.model.dto.toEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


val service = Service(
    null,
    "Transfer",
    25.0,
    1
)

class ServiceTest {

    val serviceEntity = service.toEntity()

    @Test
    fun `Happy pass - service toEntity works`() {
        assertEquals(service.serviceId, serviceEntity.serviceId)
        assertEquals(service.serviceName, serviceEntity.serviceName)
        assertEquals(service.cost, serviceEntity.cost)
        assertEquals(service.amount, serviceEntity.amount)
    }
}