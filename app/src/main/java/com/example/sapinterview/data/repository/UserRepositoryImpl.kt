package com.example.sapinterview.data.repository

import com.example.sapinterview.BuildConfig
import com.example.sapinterview.data.Util
import com.example.sapinterview.data.entities.User
import com.example.sapinterview.data.remote.ApiResponse
import com.example.sapinterview.data.remote.ServiceApi
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(val serviceApi: ServiceApi): UserRepository {
    override suspend fun getUser(): ApiResponse<User> {
        val result = serviceApi.getUserDetails(BuildConfig.BASE_URL + Util.END_POINT).await()
        if(result.isSuccessful) {
            return ApiResponse.SUCCESS(result.body())
        }
        return ApiResponse.ERROR(result.message())
    }
}