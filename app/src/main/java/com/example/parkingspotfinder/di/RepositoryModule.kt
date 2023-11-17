package com.example.parkingspotfinder.di

import com.example.parkingspotfinder.data.repository.ParkingSpotRepositoryImpl
import com.example.parkingspotfinder.domain.repository.ParkingSpotRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindParkingSpotRepository(
        parkingSpotRepositoryImpl: ParkingSpotRepositoryImpl
    ): ParkingSpotRepository

}