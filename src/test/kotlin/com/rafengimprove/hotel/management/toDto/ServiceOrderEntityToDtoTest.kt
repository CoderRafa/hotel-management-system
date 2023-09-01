package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.common.randomService
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.ServiceOrderEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class ServiceOrderEntityToDtoTest {

    private val serviceOrderEntity = randomServiceOrderEntity()
    private val serviceOrder = serviceOrderEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - convert service order entity to dto`() {
        assertEquals(serviceOrderEntity.serviceOrderId, serviceOrder.serviceOrderId)
        assertEquals(serviceOrderEntity.clientId, serviceOrder.clientId)
        assertEquals(serviceOrderEntity.workerId, serviceOrder.workerId)
        assertEquals(serviceOrderEntity.apartmentId, serviceOrder.apartmentId)
        assertEquals(serviceOrderEntity.services.map { it.toDto() }, serviceOrder.services)
        assertEquals(serviceOrderEntity.serviceOrderDateTime, serviceOrder.serviceOrderDateTime)
    }

    private fun randomServiceOrderEntity() = ServiceOrderEntity().apply {
        this.serviceOrderId = nextLong()
        this.clientId = nextLong()
        this.workerId = nextLong()
        this.apartmentId = nextLong()
        this.services = listOf(randomService().toEntity())
        this.serviceOrderDateTime = LocalDateTime.now()
    }
}