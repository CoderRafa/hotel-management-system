package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.common.randomApartmentPayment
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.payment.toEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ApartmentPaymentEntityToDtoTest {

    private val apartmentPaymentEntity = randomApartmentPayment().toEntity()
    private val apartmentPayment = apartmentPaymentEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - convert apartment payment to entity`() {
            assertEquals(apartmentPayment.paymentId, apartmentPaymentEntity.paymentId)
            assertEquals(apartmentPayment.createdDate, apartmentPaymentEntity.createdDate)
            assertEquals(apartmentPayment.confirmedDate, apartmentPaymentEntity.confirmedDate)
            assertEquals(apartmentPayment.amount, apartmentPaymentEntity.amount)
            assertEquals(apartmentPayment.paymentType, apartmentPaymentEntity.paymentType)
            assertEquals(apartmentPayment.currency, apartmentPaymentEntity.currency)
            assertEquals(apartmentPayment.status, apartmentPaymentEntity.paymentStatus)
            assertEquals(apartmentPayment.roomId, apartmentPaymentEntity.roomId)
            assertEquals(apartmentPayment.clientId, apartmentPaymentEntity.clientId)
        }
}