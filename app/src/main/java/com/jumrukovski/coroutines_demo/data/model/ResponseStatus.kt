package com.jumrukovski.coroutines_demo.data.model

sealed class ResponseStatus<out T : Any> {
    data class Success<out T : Any>(val output: T) : ResponseStatus<T>()
    data class Error(val exception: Exception) : ResponseStatus<Nothing>()
}