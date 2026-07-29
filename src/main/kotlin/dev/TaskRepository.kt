package dev

data class PagedResult<T>(val items: List<T>, val total: Int)

class TaskRepository(
    private val tasks: List<Task>,
    private val assigneeNames: Map<Long, String>
) {

    fun list(limit: Int = 20, offset: Int = 0): PagedResult<TaskWithAssignee> {
        val cappedLimit = limit.coerceIn(1, MAX_PAGE_SIZE)
        val page = tasks.drop(offset).take(cappedLimit)
        val withAssignees = page.map { task ->
            TaskWithAssignee(task, assigneeNames[task.id])
        }
        return PagedResult(withAssignees, tasks.size)
    }

    companion object {
        const val MAX_PAGE_SIZE = 100
    }
}

data class TaskWithAssignee(val task: Task, val assigneeName: String?)
