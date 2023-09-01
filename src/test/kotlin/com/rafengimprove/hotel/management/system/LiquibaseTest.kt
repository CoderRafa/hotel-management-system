package com.rafengimprove.hotel.management.system

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("h2")
@SpringBootTest
class LiquibaseTest {

    @Test
    fun `Happy pass - check migrations`() {
        }
}