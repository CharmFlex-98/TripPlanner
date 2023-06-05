package com.example.tripplanner.application

import android.app.Application
import com.example.tripplanner.data.TripDataBase
import com.example.tripplanner.repository.DefaultTripRepository

class TripApplication: Application() {
    val database by lazy { TripDataBase.getInstance(this) }
    val tripRepository by lazy { DefaultTripRepository(database.tripDao()) }
}