package dev.mariorobert.formationkotlinchat.presentation.kotlinchat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mariorobert.formationkotlinchat.data.IMessagesRepository
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter

class KotlinChatScreenViewModel(
    private val repository: IMessagesRepository,
) : ViewModel() {

    private var currentUsername: String? = null
    private val _uiState = MutableStateFlow<KotlinChatScreenUiState>(
        KotlinChatScreenUiState(
            messages = persistentListOf(),
            currentNewMessage = "",
            isSendButtonEnabled = false,
        )
    )
    val uiState: StateFlow<KotlinChatScreenUiState> = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<Events>()
    val events: SharedFlow<Events> = _events.asSharedFlow()

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
                _uiState.update { currentState ->
                    currentState.copy(
                        messages = messages.toPersistentList(),
                    )
                }
            }
        }
    }

    fun init(username: String) {
        currentUsername = username
    }

    fun onNewMessageChange(newMessage: String) {
        _uiState.update { currentState ->
            currentState.copy(
                currentNewMessage = newMessage,
                isSendButtonEnabled = newMessage.isNotBlank(),
            )
        }
    }

    fun onSendButtonClick() {
        val messageToSend = _uiState.value.currentNewMessage.trim()
        if (messageToSend.isEmpty()) return

        val username = currentUsername
            ?.takeUnless { it.isBlank() }
            ?: return

        viewModelScope.launch(Dispatchers.Default) {
            repository.sendMessage(
                authorName = username,
                content = messageToSend,
            )
            _uiState.update { currentState ->
                currentState.copy(
                    currentNewMessage = "",
                    isSendButtonEnabled = false,
                )
            }
            _events.emit(
                Events.ScrollDown,
            )
        }
    }

    sealed class Events {
        data object ScrollDown : Events()
    }
}
