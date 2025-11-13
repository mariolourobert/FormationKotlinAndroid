package dev.mariorobert.formationkotlinchat

import android.app.Application
import dev.mariorobert.formationkotlinchat.data.dataModule
import dev.mariorobert.formationkotlinchat.presentation.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class KotlinChatApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KotlinChatApplication)
            modules(
                presentationModule,
                dataModule,
            )
        }
    }
}
