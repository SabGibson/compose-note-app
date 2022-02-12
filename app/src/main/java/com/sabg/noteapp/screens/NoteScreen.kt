package com.sabg.noteapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sabg.noteapp.R
import com.sabg.noteapp.components.NoteButton
import com.sabg.noteapp.components.NoteInputText
import com.sabg.noteapp.components.NotePad
import com.sabg.noteapp.model.Note


@ExperimentalComposeUiApi
@Composable
fun NoteScreen(notesList:List<Note>, onRemoveNote: (Note) -> Unit, onAddNote: (Note) -> Unit) {


    var noteTitle by remember{
        mutableStateOf("")
    }

    var noteDescription by remember{
        mutableStateOf("")
    }



    Column(modifier = Modifier.padding(6.dp)) {

        TopAppBar(title = { Text(text = stringResource(id = R.string.app_name))}, actions = { Icon(
            imageVector = Icons.Rounded.Notifications,
            contentDescription = "Icon"
        )})

        Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

            NoteInputText(modifier = Modifier.padding(top =12.dp, bottom = 8.dp),text = noteTitle, label = "Title", onTextChange = {
                if(it.all { char -> char.isLetter() || char.isWhitespace() }) noteTitle = it
            })

            Spacer(modifier = Modifier.padding(4.dp))

            NoteInputText(modifier = Modifier.padding(top =12.dp),text = noteDescription, label = "Add a note", onTextChange = {if(it.all { char -> char.isLetter() || char.isWhitespace() }) noteDescription = it})

            Spacer(modifier = Modifier.padding(8.dp))

            NoteButton(text = "Save", onClick = { if(noteDescription.isNotEmpty() && noteTitle.isNotEmpty()) {
                onAddNote(Note(title = noteTitle, description = noteDescription))
                noteTitle = ""
                noteDescription = ""
            }

            })

            Divider(Modifier.padding(12.dp))

            LazyColumn(modifier = Modifier.padding(12.dp)){
                items(notesList){note ->
                    NotePad(note = note, onNoteClicked = {onRemoveNote(note)} )


                }

            }


        }

    }



}

