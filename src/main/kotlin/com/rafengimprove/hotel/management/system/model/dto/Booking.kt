package com.rafengimprove.hotel.management.system.model.dto

import com.rafengimprove.hotel.management.system.common.model.entity.BookingEntity
import com.rafengimprove.hotel.management.system.common.model.type.PaymentType
import com.rafengimprove.hotel.management.system.common.model.type.SpecialRequestType
import java.time.LocalDate

data class Booking(
    val apartmentId: Long? = null,
    val client: Client,
    val checkInDate: LocalDate,
    val checkOutDate: LocalDate,
    val people: List<Client>,
    val paymentType: PaymentType,
    val specialRequests: List<SpecialRequestType>,
    val promocode: String
)

fun Booking.toEntity() = BookingEntity().apply {
    this.bookingId = this@toEntity.apartmentId
    this.client = this@toEntity.client.toEntity()
    this.checkInDate = this@toEntity.checkInDate
    this.checkOutDate = this@toEntity.checkOutDate
    this.people = this@toEntity.people.map { it.toEntity() }
    this.paymentType = this@toEntity.paymentType
    this.specialRequests = this@toEntity.specialRequests.sorted().joinToString(separator = ",")
    this.promocode = this@toEntity.promocode
}





