package com.rafengimprove.hotel.management.toDto

import com.rafengimprove.hotel.management.system.model.entity.RoomEntity
import com.rafengimprove.hotel.management.system.model.entity.toDto
import com.rafengimprove.hotel.management.system.model.type.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextLong

@ExtendWith(MockitoExtension::class)
class RoomEntityToDtoTest {

    private val roomEntity = randomRoomEntity()
    private val room = roomEntity.toDto()

    @RepeatedTest(15)
    fun `Happy pass - convert room entity to dto`() {
        assertEquals(roomEntity.roomId, room.roomId)
        assertEquals(roomEntity.roomType, room.roomType)
        assertEquals(roomEntity.roomArea, room.roomArea)
        assertEquals(roomEntity.windows, room.windows.sorted().joinToString(separator = ","))
        assertEquals(roomEntity.viewType, room.viewType)
        assertEquals(roomEntity.furniture, room.furniture.sorted().joinToString(separator = ","))
        assertEquals(roomEntity.equipment, room.equipment.sorted().joinToString(separator = ","))
        assertEquals(roomEntity.balcony, room.balcony)
    }

    private fun randomRoomEntity() = RoomEntity().apply {
        this.roomId = nextLong()
        this.roomType = RoomType.values().random()
        this.roomArea = nextDouble()
        this.windows = listOf(WindowType.values().random()).sorted().joinToString(separator = ",")
        this.viewType = ViewType.values().random()
        this.furniture = listOf(FurnitureType.values().random()).sorted().joinToString(separator = ",")
        this.equipment = listOf(EquipmentType.values().random()).sorted().joinToString(separator = ",")
        this.balcony = nextBoolean()
    }
}