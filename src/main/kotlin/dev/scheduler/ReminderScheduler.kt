package dev.scheduler

import java.util.concurrent.locks.ReentrantLock

class ReminderScheduler {

    private val locks = HashMap<Long, ReentrantLock>()

    fun tick(reminderId: Long, hasFutureOccurrence: Boolean, fire: () -> Unit) {
        val lock = locks.getOrPut(reminderId) { ReentrantLock() }
        lock.lock()
        try {
            fire()
        } finally {
            lock.unlock()
            if (!hasFutureOccurrence) {
                locks.remove(reminderId)
            }
        }
    }
}
