package com.example.evstropovvsevolodtestovoeaxis.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evstropovvsevolodtestovoeaxis.database.Note
import com.example.evstropovvsevolodtestovoeaxis.repozitory.Repozitory
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotesFragmentViewModel @Inject constructor(private val repozitory: Repozitory):ViewModel() {
val notelist = repozitory.notelistInRepozitory
    fun insertNote(note: Note){
        viewModelScope.launch {
            repozitory.inserNote(note)
        }
    }
    fun deleteNote(id: Long){
        viewModelScope.launch {
            repozitory.deleteNote(id)
        }
    }
}