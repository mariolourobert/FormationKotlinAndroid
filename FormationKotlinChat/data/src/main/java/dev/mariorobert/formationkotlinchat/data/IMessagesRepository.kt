package dev.mariorobert.formationkotlinchat.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface IMessagesRepository {
    val messages: Flow<List<MessageDataModel>>

    suspend fun sendMessage(
        authorName: String,
        content: String,
    )

    fun startMessagesPolling(
        coroutineScope: CoroutineScope,
    )
}
