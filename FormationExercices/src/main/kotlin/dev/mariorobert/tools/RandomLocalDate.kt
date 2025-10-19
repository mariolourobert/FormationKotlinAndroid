package dev.mariorobert.tools

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.YearMonth
import kotlin.random.Random

fun Random.nextLocalDateTime(
    year: Int = nextInt(1900, 2100),
    month: Month = Month.of(nextInt(1, 13)),
    day: Int = nextInt(1, YearMonth.of(year, month).lengthOfMonth() + 1),
    hour: Int = nextInt(0, 24),
    minute: Int = nextInt(0, 60),
    second: Int = nextInt(0, 60),
    nanosecond: Int = nextInt(0, 1_000_000_000),
): LocalDateTime =
    LocalDateTime.of(year, month, day, hour, minute, second, nanosecond)

fun Random.nextLocalDate(
    year: Int = nextInt(1980, 2050),
    month: Month = Month.of(nextInt(1, 13)),
    day: Int = nextInt(1, YearMonth.of(year, month).lengthOfMonth() + 1),
): LocalDate =
    nextLocalDateTime(
        year = year,
        month = month,
        day = day,
    ).toLocalDate()
