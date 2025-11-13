package dev.mariorobert.formationkotlinchat.data

import dev.mariorobert.formationkotlinchat.data.database.MessageEntity
import dev.mariorobert.formationkotlinchat.data.tools.asEpochMilli
import dev.mariorobert.formationkotlinchat.data.tools.toEpochMillis

fun MessageEntity.toDataModel(): MessageDataModel =
    MessageDataModel(
        id = this.id,
        authorName = this.authorName,
        content = this.content,
        createdAt = this.createdAtTimestamp.asEpochMilli(),
    )

fun MessageDataModel.toEntity(): MessageEntity =
    MessageEntity(
        id = this.id,
        authorName = this.authorName,
        content = this.content,
        createdAtTimestamp = this.createdAt.toEpochMillis(),
    )
