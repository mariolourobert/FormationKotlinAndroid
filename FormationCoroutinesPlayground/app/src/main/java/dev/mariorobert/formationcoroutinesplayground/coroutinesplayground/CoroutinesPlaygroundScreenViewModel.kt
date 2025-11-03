package dev.mariorobert.formationcoroutinesplayground.coroutinesplayground

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Collections.emptyList

class CoroutinesPlaygroundScreenViewModel : ViewModel() {
    private val formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSS")

    private val _uiState = MutableStateFlow(
        CoroutinesPlaygroundScreenUiState(
            messages = emptyList(),
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        CoroutinesPlayground(
            coroutineScope = viewModelScope,
            print = { message ->
                _uiState.update {
                    val currentMessages = it.messages
                    val updatedMessages = currentMessages +
                        CoroutinesPlaygroundScreenUiState.Message(
                            time = LocalDateTime.now().format(formatter),
                            content = message,
                        )
                    it.copy(messages = updatedMessages)
                }
            }
        )
    }
}
