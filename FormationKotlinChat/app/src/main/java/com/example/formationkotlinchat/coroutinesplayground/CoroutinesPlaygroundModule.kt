package com.example.formationkotlinchat.coroutinesplayground

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val coroutinesPlaygroundModule = module {
    viewModelOf(::CoroutinesPlaygroundScreenViewModel)
}
