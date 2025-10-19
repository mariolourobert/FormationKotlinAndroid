package dev.mariorobert.tools

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

fun LocalDateTime.prettyFormat(): String =
    this.format(dateTimeFormatter)
