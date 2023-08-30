package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.common.randomRoom
import com.rafengimprove.hotel.management.system.model.dto.toEntity
import com.rafengimprove.hotel.management.system.model.entity.convertToType
import com.rafengimprove.hotel.management.system.model.type.EquipmentType
import com.rafengimprove.hotel.management.system.model.type.FurnitureType
import com.rafengimprove.hotel.management.system.model.type.WindowType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
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
        assertEquals(room.windows, roomEntity.windows.convertToType { WindowType.valueOf(it) })
        assertEquals(room.viewType, roomEntity.viewType)
        assertEquals(room.furniture, roomEntity.furniture.convertToType { FurnitureType.valueOf(it) })
        assertEquals(room.equipment, roomEntity.equipment.convertToType { EquipmentType.valueOf(it) })
        assertEquals(room.balcony, roomEntity.balcony)
    }
}