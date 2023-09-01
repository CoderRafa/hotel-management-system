package com.rafengimprove.hotel.management.toEntity

import com.rafengimprove.hotel.management.system.model.payment.ApartmentPayment
import com.rafengimprove.hotel.management.system.model.payment.toEntity
import com.rafengimprove.hotel.management.system.model.type.CurrencyType
import com.rafengimprove.hotel.management.system.model.type.PaymentStatusType
import com.rafengimprove.hotel.management.system.model.type.PaymentType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class ApartmentPaymentToEntityTest {

    private val apartmentPayment = randomApartmentPayment()
    private val apartmentPaymentEntity = apartmentPayment.toEntity()

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

    private fun randomApartmentPayment() = ApartmentPayment(
        nextLong(),
        LocalDate.now(),
        LocalDate.now(),
        nextDouble(),
        PaymentType.values().random(),
        CurrencyType.values().random(),
        PaymentStatusType.values().random(),
        nextLong(),
        nextLong()
    )
}