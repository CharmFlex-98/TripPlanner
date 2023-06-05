package com.example.tripplanner.Async

sealed class AsyncStatus<T> {
    class Success<T>(val data: T): AsyncStatus<T>()
    class Error(val errorMessage: String): AsyncStatus<Nothing>()
    object Loading: AsyncStatus<Nothing>()
}