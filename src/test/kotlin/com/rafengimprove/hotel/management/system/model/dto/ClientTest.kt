package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.type.BehaviourType
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextInt
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class ClientTest {

    @RepeatedTest(15)
    internal fun `Happy pass - convert client to client entity`() {
        val client = Client(
            nextLong(),
            "${nextInt()}",
            "${nextInt()}",
            "${nextInt()}",
            "${nextInt()}",
            "${nextInt()}",
            mutableListOf(),
            nextInt()
        )

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
        Assertions.assertThat(client.toEntity()).hasAllNullFieldsOrProperties()
    }
}