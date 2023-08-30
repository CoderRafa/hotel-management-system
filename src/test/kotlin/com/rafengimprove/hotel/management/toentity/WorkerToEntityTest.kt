package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.common.generateRandomLowerCaseLetterString
import com.rafengimprove.hotel.management.common.generateRandomNumberString
import com.rafengimprove.hotel.management.common.generateRandomUpperCaseLetterString
import com.rafengimprove.hotel.management.common.randomPosition
import com.rafengimprove.hotel.management.system.model.dto.Worker
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import java.time.LocalDate
import kotlin.random.Random.Default.nextLong

class WorkerToEntityTest {

    @RepeatedTest(15)
    fun `Happy pass - convert worker to entity`() {
        val worker = randomWorker()
        val workerEntity = worker.toEntity()

        assertEquals(worker.workerId, workerEntity.workerId)
        assertEquals(worker.name, workerEntity.name)
        assertEquals(worker.lastname, workerEntity.lastname)
        assertEquals(worker.socialNumber, workerEntity.socialNumber)
        assertEquals(worker.passportNumber, workerEntity.passportNumber)
        assertEquals(worker.phoneNumber, workerEntity.phoneNumber)
        assertEquals(worker.address, workerEntity.address)
        assertEquals(worker.email, workerEntity.email)
        assertEquals(worker.employmentDate, workerEntity.employmentDate)
        assertEquals(worker.contractTerminationDate, workerEntity.contractTerminationDate)
        assertEquals(worker.position, workerEntity.position.toDto())

    }
    private fun randomWorker() = Worker(
        nextLong(),
        generateRandomLowerCaseLetterString((4..8).random()).replaceFirstChar { it.uppercase() },
        generateRandomLowerCaseLetterString((7..12).random()).replaceFirstChar { it.uppercase() },
        generateRandomNumberString(12),
        "${generateRandomUpperCaseLetterString(2 )} ${generateRandomNumberString(6)}",
        generateRandomNumberString(9),
        "${generateRandomLowerCaseLetterString((7..15).random() ).replaceFirstChar { it.uppercase() }} ${generateRandomNumberString(2)} st., ap. ${generateRandomNumberString(2)}",
        "${generateRandomLowerCaseLetterString((7..12).random())}@gmail.com",
        LocalDate.now(),
        LocalDate.now(),
        randomPosition()
        )
}