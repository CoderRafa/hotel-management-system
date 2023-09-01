package com.rafengimprove.hotel.management.toEntity

import com.rafengimprove.hotel.management.common.randomSalaryPayment
import com.rafengimprove.hotel.management.system.model.payment.toEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class SalaryPaymentToEntityTest {

    private val salaryPayment = randomSalaryPayment()
    private val salaryPaymentEntity = salaryPayment.toEntity()

    @RepeatedTest(15)
    fun `Happy pass - convert salary payment to entity`() {
        assertEquals(salaryPayment.paymentId, salaryPaymentEntity.paymentId)
        assertEquals(salaryPayment.createdDate, salaryPaymentEntity.createdDate)
        assertEquals(salaryPayment.confirmedDate, salaryPaymentEntity.confirmedDate)
        assertEquals(salaryPayment.amount, salaryPaymentEntity.amount)
        assertEquals(salaryPayment.paymentType, salaryPaymentEntity.paymentType)
        assertEquals(salaryPayment.currency, salaryPaymentEntity.currency)
        assertEquals(salaryPayment.status, salaryPaymentEntity.paymentStatus)
        assertEquals(salaryPayment.bonusAmount, salaryPaymentEntity.bonusAmount)
        assertEquals(salaryPayment.penalties, salaryPaymentEntity.penalties)
        assertEquals(salaryPayment.workerId, salaryPaymentEntity.workerId)
    }
}