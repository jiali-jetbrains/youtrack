package dev.scheduler

import java.util.concurrent.locks.ReentrantLock

class ReminderScheduler {

    private val locks = HashMap<Long, ReentrantLock>()

    fun tick(reminderId: Long, fire: () -> Unit) {
        val lock = locks.getOrPut(reminderId) { ReentrantLock() }
        lock.lock()
        try {
            fire()
        } finally {
            lock.unlock()
        }
    }
}
