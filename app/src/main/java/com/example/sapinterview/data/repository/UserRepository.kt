package com.example.sapinterview.data.repository

import com.example.sapinterview.data.entities.User
import com.example.sapinterview.data.remote.ApiResponse

interface UserRepository {

    suspend fun getUser(): ApiResponse<User>
}