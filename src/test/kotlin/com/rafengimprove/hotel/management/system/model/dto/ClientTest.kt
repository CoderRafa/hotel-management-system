package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.common.randomClient
import com.rafengimprove.hotel.management.system.model.type.BehaviourType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class ClientTest {

    @RepeatedTest(15)
    internal fun `Happy pass - convert client to client entity`() {

        val client = randomClient()
        val clientEntity = client.toEntity()

        val historyRecord = HistoryRecord(
            nextLong(),
            client,
            nextLong(),
            nextLong(),
            BehaviourType.GOOD,
            LocalDateTime.now(),
            LocalDateTime.now(),
            nextBoolean(),
            nextBoolean(),
            listOf()
        )

        client.history.add(historyRecord)

        assertEquals(client.clientId, clientEntity.clientId)
        assertEquals(client.name, clientEntity.name)
        assertEquals(client.lastname, clientEntity.lastname)
        assertEquals(client.passportNumber, clientEntity.passportNumber)
        assertEquals(client.phoneNumber, clientEntity.phoneNumber)
        assertEquals(client.email, clientEntity.email)
        assertEquals(client.rating, clientEntity.rating)
    }
}