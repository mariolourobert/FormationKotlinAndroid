package dev.mariorobert.formationkotlinchat.presentation.kotlinchat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mariorobert.formationkotlinchat.data.IMessagesRepository
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter

class KotlinChatScreenViewModel(
    private val repository: IMessagesRepository,
) : ViewModel() {

    val uiState = MutableStateFlow<KotlinChatScreenUiState>(
        KotlinChatScreenUiState(
            messages = persistentListOf(),
        )
    )

    private val dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM HH:mm")

    init {
        viewModelScope.launch(Dispatchers.Default) {
            repository.messages.collect {
                val messages = it
                    .sortedByDescending { it.createdAt }
                    .map { messageDataModel ->
                        KotlinChatScreenUiState.MessageUiState(
                            id = messageDataModel.id,
                            authorName = messageDataModel.authorName,
                            content = messageDataModel.content,
                            formattedCreatedAt = messageDataModel.createdAt.format(dateTimeFormatter),
                        )
                    }
                uiState.emit(
                    KotlinChatScreenUiState(
                        messages = messages.toPersistentList(),
                    )
                )
            }
        }
        viewModelScope.launch(Dispatchers.Default) {
            delay(3000)
            repository.sendMessage(
                authorName = "Charlie",
                content = "Hey everyone, what's up?",
            )
        }
    }
}
