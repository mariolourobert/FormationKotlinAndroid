package dev.mariorobert.formationkotlinchat.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetMessageResponse(
    @SerialName("id") val id: String,
    @SerialName("createdAt") val createdAt: String,
    @SerialName("content") val content: String,
    @SerialName("author") val author: String,
)
