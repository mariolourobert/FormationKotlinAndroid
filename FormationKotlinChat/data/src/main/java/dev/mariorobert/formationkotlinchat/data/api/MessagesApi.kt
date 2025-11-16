package dev.mariorobert.formationkotlinchat.data.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

private const val apiKey = "ADD_THE_API_KEY_HERE"

interface MessagesApi {
    @Headers("X-Api-Key: $apiKey")
    @GET("messages")
    suspend fun getMessages(): List<GetMessageResponse>

    @Headers("X-Api-Key: $apiKey")
    @POST("message")
    suspend fun sendMessage(@Body sendMessageRequest: SendMessageRequest)
}
