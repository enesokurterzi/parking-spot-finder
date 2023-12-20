package com.example.parkingspotfinder.presentation.view.map

import android.location.Location
import com.example.parkingspotfinder.domain.local.parkingspot.ParkingSpot
import com.google.maps.android.compose.MapProperties

data class MapState(
//    val properties: MapProperties = MapProperties(),
    val parkingSpots: List<ParkingSpot> = emptyList(),
    val isFalloutMap: Boolean = false,
    val currentLocation: Location? = null
)
