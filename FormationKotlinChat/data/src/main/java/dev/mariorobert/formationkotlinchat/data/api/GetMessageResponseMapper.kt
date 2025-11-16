package dev.mariorobert.formationkotlinchat.data.api

import dev.mariorobert.formationkotlinchat.data.MessageDataModel
import java.time.OffsetDateTime

fun GetMessageResponse.toDataModel(): MessageDataModel = MessageDataModel(
        id = this.id,
        createdAt = OffsetDateTime.parse(this.createdAt),
        content = this.content,
        authorName = this.author,
    )
