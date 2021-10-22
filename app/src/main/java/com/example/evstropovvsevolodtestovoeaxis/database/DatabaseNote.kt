package com.example.evstropovvsevolodtestovoeaxis.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 1)
abstract class DatabaseNote : RoomDatabase(){
    abstract val noteDao: NoteDao
}
private lateinit var INSTANCE: DatabaseNote  // переменная INSTANCE для хранения одноэлементного объекта БД (чтобы не открылись неск.экз.бд)
fun getDatabaseInstanse(context: Context): DatabaseNote {
    synchronized(Note::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                DatabaseNote::class.java,
                "notes").fallbackToDestructiveMigration().build()
        }
    }
    return INSTANCE
}