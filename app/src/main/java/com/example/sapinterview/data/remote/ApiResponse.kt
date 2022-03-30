package com.example.sapinterview.data.remote

import com.example.sapinterview.data.entities.User

sealed class ApiResponse<out T: Any> {
    data class SUCCESS<T: Any>(val item: List<User>?): ApiResponse<T>()
    data class ERROR(val errorMessage: String): ApiResponse<Nothing>()
}
