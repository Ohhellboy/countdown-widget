package com.example.countdownwidget

import java.util.Calendar
import java.util.TimeZone
import java.util.concurrent.TimeUnit

object CountdownUtils {
    fun getRemainingDays(): Long {
        val now = Calendar.getInstance(TimeZone.getDefault())
        val target = Calendar.getInstance(TimeZone.getDefault()).apply {
            set(Constants.TARGET_YEAR, Constants.TARGET_MONTH - 1, Constants.TARGET_DAY, Constants.TARGET_HOUR, Constants.TARGET_MINUTE, Constants.TARGET_SECOND)
        }
        val diff = target.timeInMillis - now.timeInMillis
        return TimeUnit.MILLISECONDS.toDays(diff)
    }

    fun getDetailedCountdown(): String {
        val now = Calendar.getInstance(TimeZone.getDefault())
        val target = Calendar.getInstance(TimeZone.getDefault()).apply {
            set(Constants.TARGET_YEAR, Constants.TARGET_MONTH - 1, Constants.TARGET_DAY, Constants.TARGET_HOUR, Constants.TARGET_MINUTE, Constants.TARGET_SECOND)
        }
        var diff = target.timeInMillis - now.timeInMillis

        val days = TimeUnit.MILLISECONDS.toDays(diff)
        diff -= TimeUnit.DAYS.toMillis(days)

        val hours = TimeUnit.MILLISECONDS.toHours(diff)
        diff -= TimeUnit.HOURS.toMillis(hours)

        val minutes = TimeUnit.MILLISECONDS.toMinutes(diff)
        diff -= TimeUnit.MINUTES.toMillis(minutes)

        val seconds = TimeUnit.MILLISECONDS.toSeconds(diff)

        return "${days}天${hours}小时${minutes}分钟${seconds}秒"
    }
}
