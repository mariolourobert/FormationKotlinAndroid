package dev.mariorobert.formationkotlinchat.data

import java.time.OffsetDateTime

data class MessageDataModel(
    val id: String,
    val authorName: String,
    val content: String,
    val createdAt: OffsetDateTime,
)
