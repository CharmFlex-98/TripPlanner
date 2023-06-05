package com.example.tripplanner.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.tripplanner.model.Trip
import com.example.tripplanner.repository.TripRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.lang.IllegalArgumentException

data class TripListState(
    val tripList: List<Trip> = emptyList(),
    val isLoading: Boolean = false,
    val userMessage: String? = null
)

class TripViewModel(_repository: TripRepository): ViewModel() {
    private val _tripList = _repository.getAllTrip()
    val uiState = _tripList.map {
        TripListState(tripList = it)
    }.catch {
        emit(TripListState(userMessage = "Error loading data for source!"))
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = TripListState()
    )
}