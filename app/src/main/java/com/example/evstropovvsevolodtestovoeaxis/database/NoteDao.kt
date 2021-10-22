package com.example.evstropovvsevolodtestovoeaxis.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes ")
    fun getAll(): LiveData<List<Note>?>

    @Query("SELECT * FROM notes WHERE email = :email")
    suspend fun getByEmail(email: String?): List<Note>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insert(n: Note?) //вставки Названия методов могут быть любыми. Главное - аннотации.

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun delete(id: Long) //удаления передаем id, по которой удаляем


}