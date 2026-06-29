package dev

data class PagedResult<T>(val items: List<T>, val total: Int)

class TaskRepository(private val tasks: List<Task>) {

    fun list(limit: Int = 20, offset: Int = 0): PagedResult<Task> {
        val page = tasks.drop(offset).take(limit)
        return PagedResult(page, tasks.size)
    }
}
