package dev.mariorobert.formationkotlinchat.presentation.kotlinchat

import kotlinx.collections.immutable.ImmutableList

data class KotlinChatScreenUiState(
    val messages: ImmutableList<MessageUiState>,
    val currentNewMessage: String,
    val isSendButtonEnabled: Boolean,
) {
    data class MessageUiState(
        val id: String,
        val authorName: String,
        val content: String,
        val formattedCreatedAt: String,
    )
}
