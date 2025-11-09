package dev.mariorobert.formationkotlinchat.data

import java.time.LocalDateTime

data class MessageDataModel(
    val id: String,
    val authorName: String,
    val content: String,
    val createdAt: LocalDateTime,
)
