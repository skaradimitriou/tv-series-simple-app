package com.example.domain.models

sealed class Result<T>(
    var data: T? = null,
    var error: String? = null
) {
    class Loading<T>() : Result<T>()
    class Success<T>(data: T) : Result<T>(data = data)
    class Error<T>(error: String) : Result<T>(error = error)
}