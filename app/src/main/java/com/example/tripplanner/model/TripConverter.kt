package com.example.tripplanner.model

import androidx.room.TypeConverter
import java.time.LocalDateTime


class TripConverter {

    @TypeConverter
    fun dateToString(date: LocalDateTime): String {
        return date.toString()
    }

    @TypeConverter
    fun stringToDate(str: String): LocalDateTime {
        return LocalDateTime.parse(str)
    }
}