package com.example.evstropovvsevolodtestovoeaxis.repozitory

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.evstropovvsevolodtestovoeaxis.database.DatabaseNote
import com.example.evstropovvsevolodtestovoeaxis.database.Note
import com.example.evstropovvsevolodtestovoeaxis.database.asDomainNoteModel
import com.example.evstropovvsevolodtestovoeaxis.domain.NoteDomain

class Repozitory (val database: DatabaseNote, val context: Context){

    suspend fun inserNote(note: Note) {
        database.noteDao.insert(note)
    }
    suspend fun deleteNote(id: Long) {
        database.noteDao.delete(id)
    }
    val notelistInRepozitory: LiveData<List<NoteDomain>?> =
        Transformations.map(database.noteDao.getAll()) {
            it?.asDomainNoteModel()
        }
}