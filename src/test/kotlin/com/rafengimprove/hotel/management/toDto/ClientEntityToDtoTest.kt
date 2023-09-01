package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.common.randomClient
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ClientEntityToDtoTest {

    private val clientEntity = randomClient().toEntity()
    private val client = clientEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - convert client entity to dto`() {
        assertEquals(clientEntity.clientId, client.clientId)
        assertEquals(clientEntity.name, client.name)
        assertEquals(clientEntity.lastname, client.lastname)
        assertEquals(clientEntity.passportNumber, client.passportNumber)
        assertEquals(clientEntity.phoneNumber, client.phoneNumber)
        assertEquals(clientEntity.email, client.email)
        assertEquals(clientEntity.history.map { it.toDto() }, client.history)
        assertEquals(clientEntity.rating, client.rating)
    }

}