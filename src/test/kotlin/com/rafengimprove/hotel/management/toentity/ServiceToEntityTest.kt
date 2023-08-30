package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.common.randomService
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest


val service = randomService()

class ServiceTest {

    private val serviceEntity = service.toEntity()

    @RepeatedTest(15)
    fun `Happy pass - service toEntity works`() {
        assertEquals(service.serviceId, serviceEntity.serviceId)
        assertEquals(service.serviceName, serviceEntity.serviceName)
        assertEquals(service.cost, serviceEntity.cost)
        assertEquals(service.amount, serviceEntity.amount)
    }
}