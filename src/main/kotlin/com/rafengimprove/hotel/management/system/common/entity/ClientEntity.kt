package com.rafengimprove.hotel.management.system.common.entity

import com.rafengimprove.hotel.management.system.common.Client
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany

@Entity(name = "client")
class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sequence")
    @Column(name = "id", nullable = false)
    var clientId: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "lastname", nullable = false)
    lateinit var lastname: String

    @Column(name = "passport_number", nullable = false)
    lateinit var passportNumber: String

    @Column(name = "phone_number", nullable = false)
    lateinit var phoneNumber: String

    @Column(name = "email", nullable = false)
    lateinit var email: String

    @OneToMany(mappedBy = "client")
    lateinit var history: List<HistoryRecordEntity>

    @ManyToMany(mappedBy = "people")
    lateinit var guestHistory: List<HistoryRecordEntity>

    @Column(name = "rating", nullable = false)
    var rating: Int = 0
}

fun ClientEntity.toDto() = Client(
    clientId,
    name,
    lastname,
    passportNumber,
    phoneNumber,
    email,
    history.map(HistoryRecordEntity::toDto),
    guestHistory.map(HistoryRecordEntity::toDto),
    rating
)