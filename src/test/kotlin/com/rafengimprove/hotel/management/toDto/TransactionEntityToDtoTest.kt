package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.model.entity.TransactionEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.type.CurrencyType
import com.rafengimprove.hotel.management.system.model.type.PaymentType
import com.rafengimprove.hotel.management.system.model.type.TransactionStatusType
import com.rafengimprove.hotel.management.system.model.type.TransactionType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class TransactionEntityToDtoTest {

    private val transactionEntity = randomTransactionEntity()
    private val transaction = transactionEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - convert transaction entity to dto`() {
        assertEquals(transactionEntity.transactionId, transaction.transactionId)
        assertEquals(transactionEntity.transactionType, transaction.transactionType)
        assertEquals(transactionEntity.paymentType, transaction.paymentType)
        assertEquals(transactionEntity.createdDateTime, transaction.createdDateTime)
        assertEquals(transactionEntity.completedDateTime, transaction.completedDateTime)
        assertEquals(transactionEntity.currency, transaction.currency)
        assertEquals(transactionEntity.amount, transaction.amount)
        assertEquals(transactionEntity.status, transaction.status)
    }

    private fun randomTransactionEntity() = TransactionEntity().apply {
        this.transactionId = nextLong()
        this.transactionType = TransactionType.values().random()
        this.paymentType = PaymentType.values().random()
        this.createdDateTime = LocalDateTime.now()
        this.completedDateTime = LocalDateTime.now()
        this.currency = CurrencyType.values().random()
        this.amount = nextDouble()
        this.status = TransactionStatusType.values().random()
    }
}