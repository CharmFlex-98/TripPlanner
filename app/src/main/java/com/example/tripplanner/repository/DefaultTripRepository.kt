package com.example.tripplanner.repository

import com.example.tripplanner.data.TripDao
import com.example.tripplanner.model.Trip
import kotlinx.coroutines.flow.Flow

class DefaultTripRepository(private val _tripDao: TripDao): TripRepository {
    override fun getAllTrip(): Flow<List<Trip>> {
        return _tripDao.getAll()
    }

    override suspend fun getTrip(id: Int): Trip {
        return _tripDao.getTrip(id)
    }

    override suspend fun insertTrip(trip: Trip) {
        return _tripDao.insertTrip(trip)
    }

    override suspend fun deleteTrip(trip: Trip) {
        return _tripDao.deleteTrip(trip)
    }
}