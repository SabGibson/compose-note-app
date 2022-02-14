package com.sabg.noteapp.utility

import androidx.room.TypeConverter
import java.util.*

class UUIDConverter {
    @TypeConverter
    fun uuidConverter(uuid: UUID):String?{

        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String?) :UUID?{

        return UUID.fromString(string)
    }

}