package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.common.randomRoom
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class RoomTest {

    @RepeatedTest(15)
    fun `Happy pass - room toEntity works`() {

        val room = randomRoom()
        val roomEntity = room.toEntity()

        assertEquals(room.roomId, roomEntity.roomId)
        assertEquals(room.roomType, roomEntity.roomType)
        assertEquals(room.roomArea, roomEntity.roomArea)
        assertEquals(room.viewType, roomEntity.viewType)
        assertEquals(room.furniture, roomEntity.furniture)
        assertEquals(room.equipment, roomEntity.equipment)
        assertEquals(room.balcony, roomEntity.balcony)
    }
}