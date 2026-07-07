package dev.api

import dev.TaskRepository

class TaskListEndpoint(private val repository: TaskRepository) {

    fun handle(statusFilter: String?): List<Any> {
        val normalizedFilter = statusFilter?.takeIf { it.isNotBlank() }
        return repository.list().items.filter { normalizedFilter == null }
    }
}
