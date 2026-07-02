package dev.scheduler

import kotlin.test.Test
import kotlin.test.assertEquals

class ReminderSchedulerTest {

    @Test
    fun `concurrent ticks for the same reminder do not overlap`() {
        val scheduler = ReminderScheduler()
        var fireCount = 0
        repeat(100) {
            scheduler.tick(reminderId = 1L) { fireCount++ }
        }
        assertEquals(100, fireCount)
    }
}
