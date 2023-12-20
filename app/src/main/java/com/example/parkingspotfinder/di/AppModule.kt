package com.example.parkingspotfinder.di

import android.app.Application
import androidx.room.Room
import com.example.parkingspotfinder.data.remote.parkingspot.ParkingSpotDao
import com.example.parkingspotfinder.data.remote.parkingspot.ParkingSpotDatabase
import com.example.parkingspotfinder.data.repository.ParkingSpotRepositoryImpl
import com.example.parkingspotfinder.domain.repository.ParkingSpotRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideParkingSpotDatabase(app: Application): ParkingSpotDao {
        return Room.databaseBuilder(
            app,
            ParkingSpotDatabase::class.java,
            "parking_spots.db"
        ).build().dao
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }

}