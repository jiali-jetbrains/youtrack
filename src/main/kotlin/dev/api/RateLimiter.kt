package dev.api

import java.time.Clock
import java.time.Instant

class RateLimiter(
    private val limitPerMinute: Int = 120,
    private val clock: Clock = Clock.systemUTC()
) {
    private val windowStart = HashMap<String, Instant>()
    private val counts = HashMap<String, Int>()

    fun allow(token: String): Boolean {
        val now = Instant.now(clock)
        val start = windowStart.getOrPut(token) { now }
        if (now.epochSecond - start.epochSecond >= 60) {
            windowStart[token] = now
            counts[token] = 0
        }
        val count = counts.getOrDefault(token, 0) + 1
        counts[token] = count
        return count <= limitPerMinute
    }
}
