package com.example.tripplanner.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

interface TripDetail {
    val id: Long
    val parentTripId: Long
    val startTime: LocalDateTime
    val endTime: LocalDateTime
    val destination: String
}

@Entity
data class SceneryTripDetail(
    @PrimaryKey(autoGenerate = true)
    override val id: Long,
    override val parentTripId: Long,
    override val startTime: LocalDateTime,
    override val endTime: LocalDateTime,
    override val destination: String,
    val ticketPrice: Double
) : TripDetail