package dev.mariorobert.formationcoroutinesplayground.coroutinesplayground

data class CoroutinesPlaygroundScreenUiState(
    val messages: List<Message>,
) {
    data class Message(
        val time: String,
        val content: String,
    )
}
