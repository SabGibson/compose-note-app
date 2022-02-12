package com.sabg.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sabg.noteapp.screens.NoteScreen
import com.sabg.noteapp.screens.NoteViewModel
import com.sabg.noteapp.ui.theme.NoteAppTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            NoteAppTheme {

                Surface(color = MaterialTheme.colors.background) {
                   val noteViewModel:NoteViewModel by viewModels()
                    MyApp(noteViewModel)


                }


            }


        }
    }
}


@ExperimentalComposeUiApi
@Composable
fun MyApp(ViewModel: NoteViewModel = NoteViewModel()) {

    val noteList = ViewModel.getAllNotes()

    NoteScreen(notesList = noteList, onRemoveNote = {
        ViewModel.removeNote(it) },
        onAddNote = {
            ViewModel.addNote(it)
        })


}