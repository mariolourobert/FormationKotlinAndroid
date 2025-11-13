package dev.mariorobert.formationkotlinchat.data

import dev.mariorobert.formationkotlinchat.data.database.MessageDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import java.time.OffsetDateTime
import java.util.UUID

class MessagesRepository(
    private val messageDao: MessageDao,
) : IMessagesRepository {
    override val messages: Flow<List<MessageDataModel>> =
        messageDao.getAllMessages()
            .distinctUntilChanged()
            .map {
                it.map {
                    it.toDataModel()
                }
            }

    override suspend fun sendMessage(
        authorName: String,
        content: String,
    ) {
        messageDao.insertMessage(
            MessageDataModel(
                id = UUID.randomUUID().toString(),
                authorName = authorName,
                content = content,
                createdAt = OffsetDateTime.now(),
            ).toEntity()
        )
    }
}
