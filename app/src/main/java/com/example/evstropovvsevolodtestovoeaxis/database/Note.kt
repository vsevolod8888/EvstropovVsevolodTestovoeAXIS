package com.example.evstropovvsevolodtestovoeaxis.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.evstropovvsevolodtestovoeaxis.domain.NoteDomain

@Entity(tableName = "notes")
class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "tittle")
    val tittle: String,
    @ColumnInfo(name = "content")
    val content: String
)
fun List<Note>.asDomainNoteModel(): List<NoteDomain> { // функция для преобразования DatabaseVideo объектов базы данных в объекты домена
    return map {
        NoteDomain(
            id = it.id,
            email = it.email,
            tittle = it.tittle,
            content = it.content
        )
    }
}


