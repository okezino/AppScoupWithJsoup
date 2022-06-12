package com.example.truecallerappokeh.data.model

sealed class Resource<out T>(val data: T? = null, val messages: String? = null) {
    data class Success<T>(val displayData: T) : Resource<T>(displayData)
    data class Error<T>(val error: Throwable? = null) : Resource<T>(null)
    data class Loading<T>(val message: String = "Loading...") : Resource<T>(messages = message)
}