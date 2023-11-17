package com.example.parkingspotfinder.data.mappers

import com.example.parkingspotfinder.data.remote.parkingspot.ParkingSpotEntity
import com.example.parkingspotfinder.domain.local.parkingspot.ParkingSpot

fun ParkingSpotEntity.toParkingSpot(): ParkingSpot {
    return ParkingSpot(
        lat = lat,
        lng = lng,
        id = id
    )
}

fun ParkingSpot.toParkingSpotEntity(): ParkingSpotEntity {
    return ParkingSpotEntity(
        lat = lat,
        lng = lng,
        id = id
    )
}