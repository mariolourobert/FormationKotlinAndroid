package dev.mariorobert.formationkotlinchat.presentation

import dev.mariorobert.formationkotlinchat.presentation.kotlinchat.KotlinChatScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::KotlinChatScreenViewModel)
}
