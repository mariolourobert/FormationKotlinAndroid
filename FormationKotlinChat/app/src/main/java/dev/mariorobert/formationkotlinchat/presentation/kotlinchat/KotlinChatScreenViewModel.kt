package dev.mariorobert.formationkotlinchat.presentation.kotlinchat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mariorobert.formationkotlinchat.data.MessagesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class KotlinChatScreenViewModel(
    private val repository: MessagesRepository,
) : ViewModel() {

    val uiState = MutableStateFlow<KotlinChatScreenUiState>(
        KotlinChatScreenUiState(
            messages = emptyList(),
        )
    )

    init {
        viewModelScope.launch(Dispatchers.Default) {
            repository.messages.collect {
                val messagesAsString = it.map { messageDataModel ->
                    messageDataModel.content
                }
                uiState.emit(
                    KotlinChatScreenUiState(
                        messages = messagesAsString,
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
