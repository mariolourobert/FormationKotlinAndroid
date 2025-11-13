package dev.mariorobert.formationkotlinchat.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MessageEntity::class],
    version = 1,
)
abstract class KotlinChatLocalDatabase : RoomDatabase() {
    abstract fun getMessageDao(): MessageDao
}
