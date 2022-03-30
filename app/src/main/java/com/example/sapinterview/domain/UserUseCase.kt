package com.example.sapinterview.domain

import com.example.sapinterview.data.entities.User
import com.example.sapinterview.data.remote.ApiResponse
import com.example.sapinterview.data.repository.UserRepositoryImpl
import javax.inject.Inject

class UserUseCase @Inject constructor(val userRepositoryImpl: UserRepositoryImpl) {

    suspend fun getUserUseCase(): ApiResponse<User> {
        return userRepositoryImpl.getUser()
    }
}