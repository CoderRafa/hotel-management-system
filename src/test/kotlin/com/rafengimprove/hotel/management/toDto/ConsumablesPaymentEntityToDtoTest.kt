package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.common.randomConsumablesPayment
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.payment.toEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ConsumablesPaymentEntityToDtoTest {

    private val consumablePaymentEntity = randomConsumablesPayment().toEntity()
    private val consumablePayment = consumablePaymentEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - convert consumable payment to entity`() {
        assertEquals(consumablePayment.paymentId, consumablePaymentEntity.paymentId)
        assertEquals(consumablePayment.createdDate, consumablePaymentEntity.createdDate)
        assertEquals(consumablePayment.confirmedDate, consumablePaymentEntity.confirmedDate)
        assertEquals(consumablePayment.amount, consumablePaymentEntity.amount)
        assertEquals(consumablePayment.paymentType, consumablePaymentEntity.paymentType)
        assertEquals(consumablePayment.currency, consumablePaymentEntity.currency)
        assertEquals(consumablePayment.status, consumablePaymentEntity.status)
        assertEquals(consumablePayment.consumables, consumablePaymentEntity.consumables.map { it.toDto() })
    }
}