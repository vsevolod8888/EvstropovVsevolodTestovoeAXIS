package com.example.vrgsoft_test_yevstropov_vsevolod.dagger

import android.content.Context
import androidx.room.Room
import com.example.evstropovvsevolodtestovoeaxis.database.DatabaseNote
import com.example.evstropovvsevolodtestovoeaxis.repozitory.Repozitory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepozitoryModule(var context: Context) {
    @Provides //@Provides указывает, что метод является поставщиком объекта и компонент может использовать его, чтобы получить объект.
    @Singleton
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): DatabaseNote {
        val INSTANCE = Room.databaseBuilder(
            context.applicationContext,
            DatabaseNote::class.java,
            "notes"
        ).fallbackToDestructiveMigration().build()
        return INSTANCE
    }

    @Provides
    @Singleton
    fun providesRepozitory(db: DatabaseNote, context: Context): Repozitory {
        return Repozitory(db, context) //в модуле создаются зависимости
    }
}