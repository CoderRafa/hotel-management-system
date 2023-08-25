package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.system.common.model.dto.Transaction
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.common.model.type.CurrencyType.USD
import com.rafengimprove.hotel.management.system.common.model.type.PaymentType.TRANSFER
import com.rafengimprove.hotel.management.system.common.model.type.TransactionStatusType.APPROVED
import com.rafengimprove.hotel.management.system.common.model.type.TransactionType.REGULAR
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TransactionToEntityTest() {

    val transaction = Transaction(
        null,
        REGULAR,
        TRANSFER,
        LocalDateTime.now(),
        LocalDateTime.now(),
        USD,
        150.0,
        APPROVED
    )

    val transactionEntity = transaction.toEntity()

    @Test
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
}