package com.example.countries.util

sealed class NetworkState<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null): NetworkState<T>(data)
    class Success<T>(data: T?): NetworkState<T>(data)
    class Error<T>(message: String, data: T? = null): NetworkState<T>(data, message)
}
