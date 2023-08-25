package com.rafengimprove.hotel.management.toentity

import com.rafengimprove.hotel.management.system.common.model.dto.Room
import com.rafengimprove.hotel.management.system.common.model.dto.toEntity
import com.rafengimprove.hotel.management.system.common.model.type.EquipmentType.TV
import com.rafengimprove.hotel.management.system.common.model.type.FurnitureType.DOUBLE_BED
import com.rafengimprove.hotel.management.system.common.model.type.RoomType.BEDROOM
import com.rafengimprove.hotel.management.system.common.model.type.ViewType.SEA_VIEW
import com.rafengimprove.hotel.management.system.common.model.type.WindowType.FIXED_WINDOW
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

val room = Room(
    null,
    BEDROOM,
    10.0,
    listOf(FIXED_WINDOW),
    SEA_VIEW,
    listOf(DOUBLE_BED),
    listOf(TV),
    true
)
class RoomTest {

    val roomEntity = room.toEntity()

    @Test
    fun `Happy pass - room toEntity works`() {
        assertEquals(room.roomId, roomEntity.roomId)
        assertEquals(room.roomType, roomEntity.roomType)
        assertEquals(room.roomArea, roomEntity.roomArea)
        assertEquals(room.viewType, roomEntity.viewType)
        assertEquals(room.furniture, roomEntity.furniture)
        assertEquals(room.equipment, roomEntity.equipment)
        assertEquals(room.balcony, roomEntity.balcony)
    }
}