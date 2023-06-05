package com.example.tripplanner.repository

import com.example.tripplanner.data.TripDao
import com.example.tripplanner.model.Trip
import kotlinx.coroutines.flow.Flow

interface TripRepository {

    fun getAllTrip(): Flow<List<Trip>>

    suspend fun getTrip(id: Int): Trip

    suspend fun insertTrip(trip: Trip)

    suspend fun deleteTrip(trip: Trip)
}