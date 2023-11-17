package com.example.parkingspotfinder.data.repository

import com.example.parkingspotfinder.data.remote.parkingspot.ParkingSpotDao
import com.example.parkingspotfinder.data.mappers.toParkingSpot
import com.example.parkingspotfinder.data.mappers.toParkingSpotEntity
import com.example.parkingspotfinder.domain.local.parkingspot.ParkingSpot
import com.example.parkingspotfinder.domain.repository.ParkingSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ParkingSpotRepositoryImpl @Inject constructor(
    private val dao: ParkingSpotDao
): ParkingSpotRepository {
    override suspend fun insertParkingSpot(spot: ParkingSpot) {
        dao.insertParkingSpot(spot.toParkingSpotEntity())
    }

    override suspend fun deleteParkingSpot(spot: ParkingSpot) {
        dao.deleteParkingSpot(spot.toParkingSpotEntity())
    }

    override fun getParkingSpots(): Flow<List<ParkingSpot>> {
        return dao.getParkingSpots().map {spots ->
            spots.map {
                it.toParkingSpot()
            }
        }
    }
}