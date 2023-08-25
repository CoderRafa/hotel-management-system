package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.common.model.entity.ServiceEntity
import com.rafengimprove.hotel.management.system.common.model.entity.toDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ServiceEntityToDtoTest {

    val serviceEntity = ServiceEntity().apply {
        serviceId = null
        serviceName = "Transfer"
        cost = 25.0
        amount = 1
    }

    val service = serviceEntity.toDto()

    @Test
    fun `Happy pass - serviceEntity toDto works`() {

        assertEquals(null, service.serviceId)
        assertEquals("Transfer", service.serviceName)
        assertEquals(25.0, service.cost)
        assertEquals(1, service.amount)
    }
}