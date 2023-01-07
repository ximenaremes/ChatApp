package com.example.chatapp.data

sealed class Response<out T> {
    object Loading: Response<Nothing>()

     class Success<out T>() : Response<T>()

    data class Error(
        val message: String
    ): Response<Nothing>()
}