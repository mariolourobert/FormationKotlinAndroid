package dev.mariorobert.formationkotlinchat.presentation.signup

data class SignUpScreenUiState(
    val currentUsername: String,
    val isCheckboxChecked: Boolean,
    val isSignUpButtonEnabled: Boolean,
)
