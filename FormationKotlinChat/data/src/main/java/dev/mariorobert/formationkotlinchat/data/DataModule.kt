package dev.mariorobert.formationkotlinchat.data

import androidx.room.Room
import dev.mariorobert.formationkotlinchat.data.api.MessagesApi
import dev.mariorobert.formationkotlinchat.data.api.MessagesApiFactory
import dev.mariorobert.formationkotlinchat.data.database.KotlinChatLocalDatabase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    factoryOf(::MessagesRepository) bind IMessagesRepository::class
    single {
        Room.databaseBuilder(
            context = get(),
            klass = KotlinChatLocalDatabase::class.java,
            name = "KotlinChatLocalDatabase",
        ).build()
    }
    factory {
        get<KotlinChatLocalDatabase>().getMessageDao()
    }
    factoryOf(::MessagesApiFactory)
    single<MessagesApi> {
        get<MessagesApiFactory>().build()
    }
}
