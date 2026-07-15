package dev

import java.time.LocalDate

enum class RecurrenceRule {
    DAILY,
    WEEKLY,
    MONTHLY;

    fun nextOccurrence(from: LocalDate): LocalDate = when (this) {
        DAILY -> from.plusDays(1)
        WEEKLY -> from.plusWeeks(1)
        MONTHLY -> from.plusMonths(1)
    }
}
