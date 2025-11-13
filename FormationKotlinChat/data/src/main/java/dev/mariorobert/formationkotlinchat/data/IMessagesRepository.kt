package dev.mariorobert.formationkotlinchat.data

import kotlinx.coroutines.flow.StateFlow

interface IMessagesRepository {
    val messages: StateFlow<List<MessageDataModel>>

    suspend fun sendMessage(
        authorName: String,
        content: String,
    )
}
