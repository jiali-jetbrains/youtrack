package dev

data class PagedResult<T>(val items: List<T>, val total: Int)

class TaskRepository(private val tasks: List<Task>) {

    fun list(limit: Int = 20, offset: Int = 0): PagedResult<Task> {
        val cappedLimit = limit.coerceIn(1, MAX_PAGE_SIZE)
        val page = tasks.drop(offset).take(cappedLimit)
        return PagedResult(page, tasks.size)
    }

    companion object {
        const val MAX_PAGE_SIZE = 100
    }
}
