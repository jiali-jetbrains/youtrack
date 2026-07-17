package dev

import java.time.Instant

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val dueDateUtc: Instant?,
    val recurrenceRule: RecurrenceRule? = null
)
