package com.example.tripplanner.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tripplanner.model.Trip
import kotlinx.coroutines.flow.Flow

@Dao
interface TripDao {
    @Query("SELECT * FROM trip")
    fun getAll(): Flow<List<Trip>>

    @Query("SELECT * FROM trip WHERE id IN (:id)")
    suspend fun getTrip(id: Int): Trip

    @Insert
    suspend fun insertTrip(trip: Trip)

    @Delete
    suspend fun deleteTrip(trip: Trip)
}