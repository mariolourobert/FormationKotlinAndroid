package dev.mariorobert.formationkotlinchat.data

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    factoryOf(::MessagesRepository) bind IMessagesRepository::class
}
