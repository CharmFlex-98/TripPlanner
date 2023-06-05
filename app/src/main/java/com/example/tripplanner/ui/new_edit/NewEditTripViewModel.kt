package com.example.tripplanner.ui.new_edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.tripplanner.model.Trip
import com.example.tripplanner.repository.TripRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime


class NewEditTripViewModel(private val _repository: TripRepository) : ViewModel() {
    private val _tripName = MutableStateFlow("")
    val tripName: StateFlow<String> = _tripName

    private val _tripDestination = MutableStateFlow("")
    val tripDestination: StateFlow<String> = _tripDestination

    private val _tripStartDate = MutableStateFlow<LocalDateTime?>(null)
    val tripStartDate: StateFlow<LocalDateTime?> = _tripStartDate

    private val _tripEndDate = MutableStateFlow<LocalDateTime?>(null)
    val tripEndDate: StateFlow<LocalDateTime?> = _tripEndDate

    private val _tripDescription = MutableStateFlow("")
    val tripDescription: StateFlow<String> = _tripDescription

    /*
    * Set trip name
    */
    fun setTripName(tripName: String) {
        _tripName.value = tripName
    }


    /*
    * Set trip destination
    */
    fun setTripDestination(destination: String) {
        _tripDestination.value = destination
    }


    /*
    * Set trip start date
    */
    fun setStartDate(date: LocalDateTime) {
        _tripStartDate.value = date
    }


    /*
    * Set trip end date
    */
    fun setEndDate(date: LocalDateTime) {
        _tripEndDate.value = date
    }


    /*
    * Set trip description
    */
    fun setTripDescription(description: String) {
        _tripDescription.value = description
    }


    /*
    * Create/Edit new trip
    */
    fun createTrip() {
        if (isValidated()) {
            val newTrip = Trip(
                tripName = tripName.value,
                description = tripDescription.value,
                destination = tripDestination.value
            )
            viewModelScope.launch {
                _repository.insertTrip(newTrip)
            }
        }
    }


    /*
    * Check validation
    */
    private fun isValidated(): Boolean {
        println("${_tripName.value}  ${_tripDescription.value} ${_tripDestination.value}")
        return _tripName.value.isNotEmpty() && _tripDestination.value.isNotEmpty() && _tripDescription.value.isNotEmpty()
    }

}


