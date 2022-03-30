package com.example.sapinterview.data.remote

import com.example.sapinterview.data.entities.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ServiceApi {

    companion object {
        const val BASE_URL = "https://mocki.io/"
    }

    @GET
    fun getUserDetails(@Url url: String): Deferred<Response<List<User>>>
}