package com.rafengimprove.hotel.management.toEntity

import com.rafengimprove.hotel.management.system.model.dto.Transaction
import com.rafengimprove.hotel.management.system.model.dto.toEntity
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
class TransactionToEntityTest {

    private val transaction = randomTransaction()
    private val transactionEntity = transaction.toEntity()

    @RepeatedTest(15)
    fun `Happy pass - transaction toEntity works`() {
        assertEquals(transaction.transactionId, transactionEntity.transactionId)
        assertEquals(transaction.transactionType, transactionEntity.transactionType)
        assertEquals(transaction.paymentType, transactionEntity.paymentType)
        assertEquals(transaction.createdDateTime, transactionEntity.createdDateTime)
        assertEquals(transaction.completedDateTime, transactionEntity.completedDateTime)
        assertEquals(transaction.currency, transactionEntity.currency)
        assertEquals(transaction.amount, transactionEntity.amount)
        assertEquals(transaction.status, transactionEntity.status)


    }

    private fun randomTransaction() = Transaction(
        nextLong(),
        TransactionType.values().random(),
        PaymentType.values().random(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        CurrencyType.values().random(),
        nextDouble(),
        TransactionStatusType.values().random()
    )
}