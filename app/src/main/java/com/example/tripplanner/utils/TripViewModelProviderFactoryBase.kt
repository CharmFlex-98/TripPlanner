package com.example.tripplanner.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/*
* Provider factory class to generate viewModel.
* The whole thing can be simplified using Dependency Injection library such as Hilt
*/
class TripViewModelProviderFactory(private val _viewModelProviderCB: () -> ViewModel): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(_viewModelProviderCB()::class.java)) {
            return _viewModelProviderCB() as T
        }
        throw IllegalArgumentException("ViewModel type not found!")
    }
}