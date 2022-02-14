package com.sabg.noteapp.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sabg.noteapp.model.Note
import com.sabg.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
//    private var noteList = mutableStateListOf<Note>()

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())

    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) { repository.getAllNotes().distinctUntilChanged().
        collect { lisOfNotes ->
            if (lisOfNotes.isNullOrEmpty()) {

            } else {

                _noteList.value = lisOfNotes
            }

        } }
    }

     fun  addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }

     fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note)}

     fun  removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note)}

}