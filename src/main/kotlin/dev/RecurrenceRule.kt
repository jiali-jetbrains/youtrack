package dev

import java.time.LocalDate

enum class RecurrenceRule {
    DAILY,
    WEEKLY,
    MONTHLY;

    fun nextOccurrence(from: LocalDate): LocalDate = when (this) {
        DAILY -> from.plusDays(1)
        WEEKLY -> from.plusWeeks(1)
        MONTHLY -> {
            val next = from.plusMonths(1)
            val lastDayOfNextMonth = next.withDayOfMonth(next.lengthOfMonth())
            if (from.dayOfMonth > lastDayOfNextMonth.dayOfMonth) lastDayOfNextMonth else next
        }
    }
}
