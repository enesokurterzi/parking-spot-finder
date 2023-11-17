package com.example.parkingspotfinder.presentation.view.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    viewModel: MapsViewModel = viewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = true)
    }
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
//          You can use FAB but you must disable zoom control for that.
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                viewModel.onEvent(MapEvent.ToggleFalloutMap)
//            }) {
//                Icon(
//                    imageVector = if (viewModel.state.isFalloutMap) {
//                        Icons.Default.ToggleOff
//                    } else Icons.Default.ToggleOn,
//                    contentDescription = "Toggle Fallout map"
//                )
//            }
//        }
    ) {
        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            properties = viewModel.state.properties,
            uiSettings = uiSettings,
            onMapLongClick = { lanLng ->
                viewModel.onEvent(MapEvent.OnMapLongClick(lanLng))
            }
        ) {
            viewModel.state.parkingSpots.forEach { spot ->
                Marker(
                    state = MarkerState(LatLng(spot.lat, spot.lng)),
                    title = "Parking spot (${spot.lat}, ${spot.lng})",
                    snippet = "Long click to delete",
                    onInfoWindowLongClick = {
                        viewModel.onEvent(
                            MapEvent.OnInfoWindowLongClick(spot)
                        )
                    },
                    onClick = { marker ->
                        marker.showInfoWindow()
                        true
                    },
//                    You can customize your icon
                    icon = BitmapDescriptorFactory.defaultMarker(
//                        BitmapDescriptorFactory.HUE_GREEN
                    )
                )
            }


        }
    }
}