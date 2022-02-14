package com.sabg.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sabg.noteapp.model.Note
import com.sabg.noteapp.utility.DateConverter
import com.sabg.noteapp.utility.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {

   abstract  fun noteDao(): NoteDatabaseDao

}