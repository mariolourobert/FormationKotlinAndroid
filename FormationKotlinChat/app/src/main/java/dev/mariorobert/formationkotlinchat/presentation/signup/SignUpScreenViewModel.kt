package dev.mariorobert.formationkotlinchat.presentation.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<SignUpScreenUiState>(
        SignUpScreenUiState(
            currentUsername = "",
            isCheckboxChecked = false,
            isSignUpButtonEnabled = false,
        )
    )
    val uiState = _uiState.asStateFlow()

    fun onUsernameChange(newUsername: String) {
        _uiState.update {
            it.copy(
                currentUsername = newUsername,
                isSignUpButtonEnabled = isSignUpButtonEnabled(
                    username = newUsername,
                    isCheckboxChecked = it.isCheckboxChecked,
                ),
            )
        }
    }

    fun onCheckboxToggle(isChecked: Boolean) {
        _uiState.update {
            it.copy(
                isCheckboxChecked = isChecked,
                isSignUpButtonEnabled = isSignUpButtonEnabled(
                    username = it.currentUsername,
                    isCheckboxChecked = isChecked,
                ),
            )
        }
    }

    private fun isSignUpButtonEnabled(
        username: String,
        isCheckboxChecked: Boolean,
    ): Boolean =
        username.isNotBlank() && isCheckboxChecked
}
