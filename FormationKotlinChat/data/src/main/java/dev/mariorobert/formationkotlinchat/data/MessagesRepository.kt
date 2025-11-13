package dev.mariorobert.formationkotlinchat.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.OffsetDateTime

class MessagesRepository : IMessagesRepository {
    private val initialMessages = listOf(
        MessageDataModel(
            id = "2",
            authorName = "Alice",
            content = "Doing well, thanks for asking!",
            createdAt = OffsetDateTime.now().minusMinutes(1)
        ),
        MessageDataModel(
            id = "1",
            authorName = "Bob",
            content = "I'm good, thanks! And you?",
            createdAt = OffsetDateTime.now().minusMinutes(3)
        ),
        MessageDataModel(
            id = "0",
            authorName = "Alice",
            content = "Hello, how are you?",
            createdAt = OffsetDateTime.now().minusMinutes(5)
        ),
    )
    private val _messages = MutableStateFlow(
        initialMessages,
    )
    override val messages: StateFlow<List<MessageDataModel>> = _messages.asStateFlow()

    override fun sendMessage(
        authorName: String,
        content: String,
    ) {
        _messages.update {
            it + MessageDataModel(
                id = it.size.toString(),
                authorName = authorName,
                content = content,
                createdAt = OffsetDateTime.now(),
            )
        }
    }
}
