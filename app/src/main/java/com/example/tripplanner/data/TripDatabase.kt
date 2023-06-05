package com.example.tripplanner.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.tripplanner.model.Trip
import com.example.tripplanner.model.TripConverter

@Database(entities = [Trip::class], version = 1)
@TypeConverters(TripConverter::class)
abstract class TripDataBase: RoomDatabase() {

    companion object {
        const val databaseName = "trip_database"
        // Singleton
        @Volatile
        private var instance: TripDataBase? = null

        fun getInstance(context: Context): TripDataBase {
            return instance ?: synchronized(this) {
                val item = Room.databaseBuilder(
                    context.applicationContext,
                    TripDataBase::class.java,
                    databaseName
                ).build()
                instance = item
                item
            }
        }
    }
    // Dao for accessing trip data object
    abstract fun tripDao(): TripDao

    // Might have other Daos in the future
}
