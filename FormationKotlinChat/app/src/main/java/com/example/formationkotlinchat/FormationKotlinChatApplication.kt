package com.example.formationkotlinchat

import android.app.Application
import com.example.formationkotlinchat.coroutinesplayground.coroutinesPlaygroundModule
import org.koin.core.context.startKoin

class FormationKotlinChatApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                coroutinesPlaygroundModule,
            )
        }
    }
}
