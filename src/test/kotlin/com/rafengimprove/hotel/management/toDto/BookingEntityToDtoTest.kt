package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.common.generateRandomLowerCaseLetterString
import com.rafengimprove.hotel.management.common.randomClient
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.BookingEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.type.PaymentType
import com.rafengimprove.hotel.management.system.model.type.SpecialRequestType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.random.Random.Default.nextLong

class BookingEntityToDtoTest {

    private val bookingEntity = randomBookingEntity()
    private val booking = bookingEntity.toDto()

    @Test
    fun `Happy pass - convert bookingEntity to Dto`() {
        assertEquals(bookingEntity.bookingId, booking.bookingId)
        assertEquals(bookingEntity.apartmentId, booking.apartmentId)
        assertEquals(bookingEntity.client.toDto(), booking.client)
        assertEquals(bookingEntity.checkInDate, booking.checkInDate)
        assertEquals(bookingEntity.checkOutDate, booking.checkOutDate)
        assertEquals(bookingEntity.paymentType, booking.paymentType)
        assertEquals(bookingEntity.specialRequests, booking.specialRequests.sorted().joinToString(separator = ","))
        assertEquals(bookingEntity.promocode, booking.promocode)
    }

    private fun randomBookingEntity() = BookingEntity().apply {
       this.bookingId = nextLong()
       this.apartmentId = nextLong()
       this.client = randomClient().toEntity()
       this.checkInDate = LocalDateTime.now()
       this.checkOutDate = LocalDateTime.now()
       this.paymentType = PaymentType.values().random()
       this.specialRequests = listOf(SpecialRequestType.values().random()).sorted().joinToString(separator = ",")
       this.promocode = generateRandomLowerCaseLetterString(7)
    }
}