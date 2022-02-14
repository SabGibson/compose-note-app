package com.sabg.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import com.sabg.noteapp.screens.NoteScreen
import com.sabg.noteapp.screens.NoteViewModel
import com.sabg.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
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
fun MyApp(ViewModel: NoteViewModel) {

    val noteList = ViewModel.noteList.collectAsState().value

    NoteScreen(notesList = noteList, onRemoveNote = {
        ViewModel.removeNote(it) },
        onAddNote = {
            ViewModel.addNote(it)
        })


}