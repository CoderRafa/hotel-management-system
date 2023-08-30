package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.model.entity.ServiceEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextInt

class ServiceEntityToDtoTest {

    val serviceEntity = randomServiceEntity()

    val service = serviceEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - serviceEntity toDto works`() {

        assertEquals(null, service.serviceId)
        assertEquals("Transfer", service.serviceName)
        assertEquals(serviceEntity.cost, service.cost)
        assertEquals(serviceEntity.amount, service.amount)
    }

    private fun randomServiceEntity() = ServiceEntity().apply {
        serviceId = null
        serviceName = "Transfer"
        cost = nextDouble()
        amount = nextInt()
    }
}