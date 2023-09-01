package com.rafengimprove.hotel.management.common

import com.rafengimprove.hotel.management.system.model.payment.ApartmentPayment
import com.rafengimprove.hotel.management.system.model.payment.ConsumablesPayment
import com.rafengimprove.hotel.management.system.model.payment.SalaryPayment
import com.rafengimprove.hotel.management.system.model.type.CurrencyType
import com.rafengimprove.hotel.management.system.model.type.PaymentStatusType
import com.rafengimprove.hotel.management.system.model.type.PaymentType
import java.time.LocalDate
import kotlin.random.Random

fun randomApartmentPayment() = ApartmentPayment(
    Random.nextLong(),
    LocalDate.now(),
    LocalDate.now(),
    Random.nextDouble(),
    PaymentType.values().random(),
    CurrencyType.values().random(),
    PaymentStatusType.values().random(),
    Random.nextLong(),
    Random.nextLong()
)

fun randomConsumablesPayment() = ConsumablesPayment(
    Random.nextLong(),
    LocalDate.now(),
    LocalDate.now(),
    Random.nextDouble(),
    PaymentType.values().random(),
    CurrencyType.values().random(),
    PaymentStatusType.values().random(),
    listOf(randomConsumable())
)

fun randomSalaryPayment() = SalaryPayment(
    Random.nextLong(),
    LocalDate.now(),
    LocalDate.now(),
    Random.nextDouble(),
    PaymentType.values().random(),
    CurrencyType.values().random(),
    PaymentStatusType.values().random(),
    Random.nextDouble(),
    Random.nextDouble(),
    Random.nextLong()
)