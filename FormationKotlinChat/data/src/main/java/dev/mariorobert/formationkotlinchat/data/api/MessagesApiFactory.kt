package dev.mariorobert.formationkotlinchat.data.api

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

private const val BASE_URL = "https://kotlinchat.mariorobert.dev"

class MessagesApiFactory {
    fun build(): MessagesApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                Json.asConverterFactory(
                    contentType = "application/json; charset=UTF8".toMediaType(),
                )
            )
            .build()

        return retrofit.create(MessagesApi::class.java)
    }
}
