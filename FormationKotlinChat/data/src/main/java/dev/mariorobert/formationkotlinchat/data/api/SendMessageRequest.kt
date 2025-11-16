package dev.mariorobert.formationkotlinchat.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SendMessageRequest(
    @SerialName("content") val content: String,
    @SerialName("author") val author: String,
)
