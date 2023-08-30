package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.common.generateRandomLowerCaseLetterString
import com.rafengimprove.hotel.management.common.randomClient
import com.rafengimprove.hotel.management.system.model.dto.Booking
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.convertToType
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.type.PaymentType
import com.rafengimprove.hotel.management.system.model.type.SpecialRequestType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import java.time.LocalDateTime

class BookingToEntityTest {

    @RepeatedTest(15)
    fun `Happy pass - convert booking to entity`() {
        val booking = randomBooking()
        val bookingEntity = booking.toEntity()

        assertEquals(booking.bookingId, bookingEntity.bookingId)
        assertEquals(booking.apartmentId, bookingEntity.apartmentId)
        assertEquals(booking.client, bookingEntity.client.toDto())
        assertEquals(booking.checkInDate, bookingEntity.checkInDate)
        assertEquals(booking.checkOutDate, bookingEntity.checkOutDate)
        assertEquals(booking.paymentType, bookingEntity.paymentType)
        assertEquals(booking.specialRequests, bookingEntity.specialRequests.convertToType { SpecialRequestType.valueOf(it) })
        assertEquals(booking.promocode, bookingEntity.promocode)
    }

    private fun randomBooking() = Booking(
        null,
        null,
        randomClient(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        PaymentType.values().random(),
        listOf(SpecialRequestType.values().random()),
        generateRandomLowerCaseLetterString(7)

    )
}