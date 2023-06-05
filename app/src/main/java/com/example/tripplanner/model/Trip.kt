package com.example.tripplanner.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.time.LocalDateTime

@Entity
data class Trip(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val tripName: String,
    val destination: String,
    val startDate: LocalDateTime? = null,
    val endDate: LocalDateTime? = null,
    val description: String,
)



