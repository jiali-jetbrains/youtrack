package dev

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val dueDate: String?,
    val recurrenceRule: RecurrenceRule? = null
)
