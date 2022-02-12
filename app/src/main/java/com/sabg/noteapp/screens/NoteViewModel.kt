package com.sabg.noteapp.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.sabg.noteapp.model.Note

class NoteViewModel : ViewModel() {
    private var noteList = mutableStateListOf<Note>()



    fun addNote(note:Note) {
        noteList.add(note)
    }

    fun removeNote(note:Note){
        noteList.remove(note)
    }

    fun getAllNotes() :List<Note>{

        return noteList
    }
}