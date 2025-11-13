package dev.mariorobert.formationkotlinchat.data.tools

import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset

fun Long.asEpochMilli(): OffsetDateTime =
    OffsetDateTime.ofInstant(
        Instant.ofEpochMilli(this),
        ZoneOffset.UTC,
    )

fun OffsetDateTime.toEpochMillis(): Long =
    this.toInstant().toEpochMilli()
