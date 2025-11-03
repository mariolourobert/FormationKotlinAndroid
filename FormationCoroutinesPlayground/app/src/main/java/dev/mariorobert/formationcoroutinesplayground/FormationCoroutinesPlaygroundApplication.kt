package dev.mariorobert.formationcoroutinesplayground

import android.app.Application
import dev.mariorobert.formationcoroutinesplayground.coroutinesplayground.coroutinesPlaygroundModule
import org.koin.core.context.startKoin

class FormationCoroutinesPlaygroundApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                coroutinesPlaygroundModule,
            )
        }
    }
}