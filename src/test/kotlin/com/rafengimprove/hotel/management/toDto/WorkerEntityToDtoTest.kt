package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.common.generateRandomLowerCaseLetterString
import com.rafengimprove.hotel.management.common.generateRandomNumberString
import com.rafengimprove.hotel.management.common.generateRandomUpperCaseLetterString
import com.rafengimprove.hotel.management.common.randomPosition
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.WorkerEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class WorkerEntityToDtoTest {

    private val workerEntity = randomWorkerEntity()
    private val worker = workerEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - convert worker entity to dto`() {
        assertEquals(workerEntity.workerId, worker.workerId)
        assertEquals(workerEntity.name, worker.name)
        assertEquals(workerEntity.lastname, worker.lastname)
        assertEquals(workerEntity.socialNumber, worker.socialNumber)
        assertEquals(workerEntity.passportNumber, worker.passportNumber)
        assertEquals(workerEntity.phoneNumber, worker.phoneNumber)
        assertEquals(workerEntity.address, worker.address)
        assertEquals(workerEntity.email, worker.email)
        assertEquals(workerEntity.employmentDate, worker.employmentDate)
        assertEquals(workerEntity.contractTerminationDate, worker.contractTerminationDate)
        assertEquals(workerEntity.position.toDto(), worker.position)
    }

    private fun randomWorkerEntity() = WorkerEntity().apply {
        this.workerId = nextLong()
        this.name = generateRandomLowerCaseLetterString((6..8).random()).replaceFirstChar { it.uppercase() }
        this.lastname = generateRandomLowerCaseLetterString((8..12).random()).replaceFirstChar { it.uppercase() }
        this.socialNumber = generateRandomNumberString(12)
        this.passportNumber = "${generateRandomUpperCaseLetterString(2 )} ${generateRandomNumberString(6)}"
        this.phoneNumber = generateRandomNumberString(9)
        this.address = "${generateRandomLowerCaseLetterString((7..15).random() ).replaceFirstChar { it.uppercase() }} ${generateRandomNumberString(2)} st., ap. ${generateRandomNumberString(2)}"
        this.email = "${generateRandomLowerCaseLetterString((7..12).random())}@gmail.com"
        this.employmentDate =  LocalDate.now()
        this.contractTerminationDate = LocalDate.now()
        this.position = randomPosition().toEntity()
    }

}