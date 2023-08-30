package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.model.entity.BookingEntity
import com.rafengimprove.hotel.management.system.model.type.PaymentType
import com.rafengimprove.hotel.management.system.model.type.SpecialRequestType
import java.time.LocalDate
import java.time.LocalDateTime

data class Booking(
    val bookingId: Long? = null,
    val apartmentId: Long? = null,
    val client: Client,
    val checkInDate: LocalDateTime,
    val checkOutDate: LocalDateTime,
    val paymentType: PaymentType,
    val specialRequests: List<SpecialRequestType>,
    val promocode: String
)

fun Booking.toEntity() = BookingEntity().apply {
    this.bookingId = this@toEntity.bookingId
    this.apartmentId = this@toEntity.apartmentId
    this.client = this@toEntity.client.toEntity()
    this.checkInDate = this@toEntity.checkInDate
    this.checkOutDate = this@toEntity.checkOutDate
    this.paymentType = this@toEntity.paymentType
    this.specialRequests = this@toEntity.specialRequests.sorted().joinToString(separator = ",")
    this.promocode = this@toEntity.promocode
}





