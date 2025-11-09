package dev.mariorobert.formationkotlinchat.presentation.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<SignUpScreenUiState>(
        SignUpScreenUiState(
            currentUsername = "",
        )
    )
    val uiState = _uiState.asStateFlow()

    fun onUsernameChange(newUsername: String) {
        _uiState.update {
            it.copy(
                currentUsername = newUsername,
            )
        }
    }
}
