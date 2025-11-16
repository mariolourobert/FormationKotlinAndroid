package dev.mariorobert.formationkotlinchat.data

import android.util.Log
import dev.mariorobert.formationkotlinchat.data.api.MessagesApi
import dev.mariorobert.formationkotlinchat.data.api.SendMessageRequest
import dev.mariorobert.formationkotlinchat.data.api.toDataModel
import dev.mariorobert.formationkotlinchat.data.database.MessageDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

private const val MESSAGES_POLLING_DELAY_MS = 2_000L

class MessagesRepository(
    private val messagesApi: MessagesApi,
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
        try {
            messagesApi.sendMessage(
                SendMessageRequest(
                    author = authorName,
                    content = content,
                )
            )
        } catch (exception: IOException) {
            Log.e("MessagesRepository", exception.message ?: "")
        } catch (exception: HttpException) {
            Log.e("MessagesRepository", exception.message ?: "")
        }
    }

    override fun startMessagesPolling(coroutineScope: CoroutineScope) {
        coroutineScope.launch(Dispatchers.Default) {
            while (isActive) {
                refreshMessages()
                delay(MESSAGES_POLLING_DELAY_MS)
            }
        }
    }

    private suspend fun refreshMessages() {
        try {
            Log.d("MessagesRepository", "refreshMessages")
            messagesApi.getMessages()
                .map {
                    it.toDataModel()
                }
                .forEach { messageDataModel ->
                    Log.d("MessagesRepository", messageDataModel.toString())
                    messageDao.insertMessage(messageDataModel.toEntity())
                }
        } catch (exception: IOException) {
            Log.e("MessagesRepository", exception.message ?: "")
        } catch (exception: HttpException) {
            Log.e("MessagesRepository", exception.message ?: "")
        }
    }
}
